import pandas as pd
pd.DataFrame({'Bob': ['I liked it.', 'It was awful.'], 
              'Sue': ['Pretty good.', 'Bland.']},
             index=['Product A', 'Product B'])

pd.Series([30, 35, 40], index=['2015 Sales', '2016 Sales', '2017 Sales'], name='Product A')

reviews = pd.read_csv("C://Users//LENOVO//Desktop//Codigos//Codigos phyton//kaggle//pandas_wineReviews//winemag-data-130k-v2.csv", index_col=0)

print('\n' + reviews['country'][0] + '\n') #Melhor utilizr o loc e iloc do pandas
#iloc = Index-based selection, seleciona dados baseado na sua posição numérica
print(reviews.iloc[0])
# Em iloc e loc, primeiro vem a fileira(horizontal) e depois a coluna(vertical) (: = tudo // 6:9 =  de 6 ate 8)
print(reviews.iloc[0:9, 0])
#loc = Label-based selection, seleciona dados baseado no valor do index
print(reviews.loc[0, 'country'])
print(reviews.loc[:, ['taster_name', 'taster_twitter_handle', 'points']])

print(reviews.loc[reviews.country == 'Italy']) #selecionar fileiras italianas apenas
print(reviews[reviews.country.isin(['Italy', 'France'])]) #isin do pandas ajuda selecionar varios
reviews.loc[reviews.price.notnull()] #não mostrar NaN // dropna() tambem funciona sem ter que utilizar loc
top_oceania_wines = reviews.loc[(reviews.country.isin(['Australia','New Zealand'])) & (reviews.points >= 95)]

#------------------------------------------------------------------

reviews.taster_name.unique()
reviews.taster_name.value_counts() #é usada para contar a frequência de valores únicos (Util)

#Utilizando map()
review_points_mean = reviews.points.mean()
print(reviews.points.map(lambda p: p - review_points_mean))
#Utilizando apply() (aplica uma função em um axis no database)
def remean_points(row):
    row.points = row.points - review_points_mean
    return row
reviews.apply(remean_points, axis='columns')
#utilizando operações básicas
reviews.points - review_points_mean

#idxmax() id do maior
bargain_ratio = reviews.points / reviews.price
bargain_idx = bargain_ratio.idxmax()
bargain_wine = reviews.loc[bargain_idx, 'title']

# exemplo complexo de map()
tropical_amount = reviews.description.map(lambda d: "tropical" in d).sum()
fruity_amount = reviews.description.map(lambda d: "fruity"in d).sum()
descriptor_counts = pd.Series([tropical_amount, fruity_amount], index=["tropical","fruity"])

#------------------------------------------------------------------

#lembrar estudar groupby()
print(reviews.groupby('points').points.count())
print(reviews.groupby('winery').apply(lambda df: df.title.iloc[0]))
print(reviews.groupby(['country', 'province']).apply(lambda df: df.loc[df.points.idxmax()]))
#indexs multiplos
print(reviews.groupby('country').price.agg([len, min, max]))

countries_reviewed = reviews.groupby(['country', 'province']).description.agg([len]) #(coluna description)
print(countries_reviewed.sort_values(by='len', ascending=False))
print(countries_reviewed.sort_values(by=['country','len']))
country_variety_counts = reviews.groupby(['country','variety']).size().sort_values(ascending=False)
print(country_variety_counts)
#reviews['country'].sum() reviews.country.sum() mesma coisa, porem o primeiro é mais seguro quando a coluna tem caracteres como espaço

#------------------------------------------------------------------

#datatype e nulls
reviews.points.dtype # = dtype('int64')
reviews.points.astype('float64') # mudar para 'float64' / 84 -> 84.0

#NaN são sempre 'float64' / usando fillna() NaN -> Unknown e replace para trocas especificas
print(reviews.region_2.fillna("Unknown"))
reviews.taster_twitter_handle.replace("@kerinokeefe", "@kerino")

reviews_per_region = reviews['region_1'].fillna('Unknown').value_counts().sort_values(ascending = False)

#------------------------------------------------------------------

#Renomeando e combinando
reviews.rename(columns={'points':'score'})
reviews.rename(index={0: 'firstEntry', 1: 'secondEntry'})
reviews.rename_axis("wines", axis='rows').rename_axis("fields", axis='columns') #renomear nome da coluna e fileira

canadian_youtube = pd.read_csv("../input/youtube-new/CAvideos.csv")
british_youtube = pd.read_csv("../input/youtube-new/GBvideos.csv")
pd.concat([canadian_youtube, british_youtube])

left = canadian_youtube.set_index(['title', 'trending_date'])
right = british_youtube.set_index(['title', 'trending_date'])
left.join(right, lsuffix='_CAN', rsuffix='_UK')