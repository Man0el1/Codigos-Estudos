import pandas as pd
pd.plotting.register_matplotlib_converters()
import matplotlib.pyplot as plt
import seaborn as sns

flight_filepath = "C://Users//LENOVO//Desktop//Codigos//Codigos phyton//kaggle//data_visualization//3_atrasos//flight_delays.csv"
flight_data = pd.read_csv(flight_filepath, index_col="Month")

#barplot

plt.figure(figsize=(10,6))
plt.title("Average Arrival Delay for Spirit Airlines Flights, by Month")
plt.ylabel("Arrival delay (in minutes)")

sns.barplot(x=flight_data.index, y=flight_data['NK'])

#heatmap

plt.figure(figsize=(14,7))
plt.title("Average Arrival Delay for Each Airline, by Month")
plt.xlabel("Airline")

sns.heatmap(data=flight_data, annot=True)
sns.dogplot()
plt.show()

#sns.scatterplot(x=insurance_data['bmi'], y=insurance_data['charges'], hue=insurance_data['smoker'])
#sns.regplot()
#sns.lmplot() "duas linhas de regresão"
#sns.swarmplot() "arvore"
#sns.jointplot(x=iris_data['Petal Length (cm)'], y=iris_data['Sepal Width (cm)'], kind="kde")