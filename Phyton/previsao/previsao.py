import pandas as pd
from sklearn.impute import SimpleImputer
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_absolute_error
from sklearn.model_selection import train_test_split
pd.plotting.register_matplotlib_converters()
import matplotlib.pyplot as plt
import seaborn as sns

residuos_file_path = "Phyton//previsao//dados_previsao.csv"
residuos_data = pd.read_csv(residuos_file_path, index_col="Ano")

y = residuos_data["Total Aterros(Ton)"]
X = residuos_data.drop(columns=["Total Aterros(Ton)"])

X_train, X_valid, y_train, y_valid = train_test_split(X, y, train_size=0.8, test_size=0.2, random_state=0)

# Caso dados nulos forem inseridos em uma coluna numérica
imputer = SimpleImputer()
imputed_X_train = pd.DataFrame(imputer.fit_transform(X_train))
imputed_X_valid = pd.DataFrame(imputer.transform(X_valid))

# Re: incerindo colunas
imputed_X_train.columns = X_train.columns
imputed_X_valid.columns = X_valid.columns

model = RandomForestRegressor(n_estimators=1000, random_state=0, max_depth=4)

def pontuar_previsao(X_train, X_valid, y_train, y_valid):
    model.fit(X_train, y_train)
    preds = model.predict(X_valid)
    print(f"Previsoes do treino:{preds}")
    return int(mean_absolute_error(y_valid, preds))

print(f"pontuacao do treino: {pontuar_previsao(imputed_X_train, imputed_X_valid, y_train, y_valid)}")
print(y_valid)

previsao_file_path = "Phyton//previsao//dados_futuros.csv"
previsao_data = pd.read_csv(previsao_file_path, index_col="Ano")

X_previsao = previsao_data.drop(columns=["Total Aterros(Ton)"])
# Inserindo colunas
imputed_X_previsao = pd.DataFrame(imputer.transform(X_previsao))
imputed_X_previsao.columns = X_previsao.columns

previsao = model.predict(imputed_X_previsao)
print(f"previsao:{previsao}")

previsao_data["Total Aterros(Ton)"] = previsao

# divisao de dados para visualizacao
dados_reais = residuos_data["Total Aterros(Ton)"]
dados_previsoes = previsao_data["Total Aterros(Ton)"]

ultimo_real = dados_reais.iloc[-1]
primeiro_previsto = dados_previsoes.iloc[0]
index_conexao = [dados_reais.index[-1], dados_previsoes.index[0]]
valores_conexao = [ultimo_real, primeiro_previsto]

plt.figure(figsize=(7,4))
plt.title(":3")
plt.xlabel("Ano")
plt.ylabel("Quantidade de dejetos")
plt.gca().xaxis.set_major_formatter(plt.FuncFormatter(lambda x, _: int(x)))

sns.lineplot(x=dados_reais.index, y=dados_reais.values)
sns.lineplot(x=dados_previsoes.index, y=dados_previsoes.values, linestyle='--', color='cyan')
plt.plot(index_conexao, valores_conexao, linestyle="--", color="cyan")

plt.show()