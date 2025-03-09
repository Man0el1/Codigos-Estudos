import pandas as pd
from sklearn.tree import DecisionTreeRegressor
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_absolute_error
from sklearn.model_selection import train_test_split

melbourne_file_path = "C://Users//LENOVO//Desktop//Codigos//Codigos phyton//kaggle//machineLearning_Melbourne//melb_data.csv"
melbourne_data = pd.read_csv(melbourne_file_path)

#--Mostrar tabela simplificada
print(melbourne_data.describe())

#--Mostrar o nome das colunas que formam a tabela
#print(melbourne_data.columns)

#--Mostrar info sobre a coluna "Price"
y = melbourne_data.Price
print(y)

#--Criando features (selecionando colunas de uma tabela)
melbourne_features = ['Rooms','Bathroom','Landsize','Lattitude','Longtitude']
X = melbourne_data[melbourne_features]
print(X.describe())
print(X.head())
print(melbourne_data.columns)

#--Machine learning
# Definir o modelo. (Specify a number for random_state to ensure same results each run)
melbourne_model = DecisionTreeRegressor(random_state = 1)
#Treinar o modelo (features/target)
melbourne_model.fit(X,y) 
print("previsoes para as seguintes casas")
print(X.head())
print("as previsoes são:")
print(melbourne_model.predict(X.head()))

#a margem de erro entre o previsto com o atual é diferente
predicted_home_prices = melbourne_model.predict(X)
print(mean_absolute_error(y,predicted_home_prices))

#essa diferença pode aumentar ainda mais
#divisão dos dados, 75% train, 25% val
train_X, val_X, train_Y, val_Y = train_test_split(X, y, random_state = 0)
#definindo e treinando o modelo
melbourne_model = DecisionTreeRegressor()
melbourne_model.fit(train_X, train_Y)
#previsão
val_predictions = melbourne_model.predict(val_X)
print("previsão dividida 75/25")
print(mean_absolute_error(val_Y, val_predictions))

#Underfitting e Overfitting
def get_MAE(max_leaf_nodes, train_X, val_X, train_Y, val_Y):
    model = DecisionTreeRegressor(max_leaf_nodes=max_leaf_nodes, random_state=0)
    model.fit(train_X, train_Y)
    preds_val = model.predict(val_X)
    mae = mean_absolute_error(val_Y, preds_val)
    return(mae)

for max_leaf_nodes in [5, 50, 500, 5000]:
    my_mae = get_MAE(max_leaf_nodes, train_X, val_X, train_Y, val_Y)
    print("Max leaf nodes: %d  \t\t Mean Absolute Error:  %d" %(max_leaf_nodes, my_mae))
    
#Random forest
forest_model = RandomForestRegressor(n_estimators=175, random_state=1)
forest_model.fit(train_X, train_Y)
melb_preds = forest_model.predict(val_X)
print("Utilizando Random Forest")
print(int(mean_absolute_error(val_Y, melb_preds)))