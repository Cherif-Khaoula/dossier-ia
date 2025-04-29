# Importation des bibliothèques nécessaires
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import LabelEncoder
from sklearn.metrics import classification_report

# Chargement des données depuis un fichier CSV
data = pd.read_csv('dossiers.csv')

# Encodage des colonnes catégoriques en valeurs numériques
encoder = LabelEncoder()
data['Typologie du marché'] = encoder.fit_transform(data['Typologie du marché'])
data['Garantie'] = encoder.fit_transform(data['Garantie'])
data['Situation fiscale'] = encoder.fit_transform(data['Situation fiscale'])
data['Fournisseur blacklisté'] = encoder.fit_transform(data['Fournisseur blacklisté'])
data['Visa (Oui/Non)'] = encoder.fit_transform(data['Visa (Oui/Non)'])

# Séparation des caractéristiques (features) et de la cible (target)
X = data.drop(columns=['Visa (Oui/Non)'])  # Toutes les colonnes sauf 'Visa (Oui/Non)'
y = data['Visa (Oui/Non)']  # Colonne cible

# Division des données en ensemble d'entraînement et de test
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# Création et entraînement du modèle Random Forest
rf = RandomForestClassifier(n_estimators=100, random_state=42)  # Vous pouvez ajuster n_estimators
rf.fit(X_train, y_train)

# Évaluation du modèle
y_pred = rf.predict(X_test)
print(classification_report(y_test, y_pred))

# Sauvegarde du modèle Random Forest
import joblib
joblib.dump(rf, 'modele_rf.pkl')
print("Modèle Random Forest sauvegardé sous le nom 'modele_rf.pkl'.")

# Chargement du modèle sauvegardé pour utilisation future
modele_charge = joblib.load('modele_rf.pkl')
print("Modèle chargé avec succès.")

# Exemple de prédiction avec le modèle chargé
nouvelle_donnee = [[1, 5000000, 1, 6, 10, 2, 13, 45000000, 1, 0]]  # Exemple
prediction = modele_charge.predict(nouvelle_donnee)
print("Prédiction pour le dossier :", "Visa Accordé" if prediction[0] == 1 else "Visa Refusé")
