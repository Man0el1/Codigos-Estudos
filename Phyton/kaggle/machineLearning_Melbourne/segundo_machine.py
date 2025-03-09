import pandas as pd
from sklearn.impute import SimpleImputer
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_absolute_error
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import OrdinalEncoder

melbourne_file_path = "C://Users//LENOVO//Desktop//Codigos//Codigos phyton//kaggle//machineLearning_Melbourne//melb_data.csv"
melbourne_data = pd.read_csv(melbourne_file_path)

# Select target
y = melbourne_data['Price']

# To keep things simple, we'll use only numerical predictors
melb_predictors = melbourne_data.drop(['Price'], axis=1)
X = melb_predictors.select_dtypes(exclude=['object'])

# Divide data into training and validation subsets 80%/20%
X_train, X_valid, y_train, y_valid = train_test_split(X, y, train_size=0.8, test_size=0.2,random_state=0)

def score_dataset(X_train, X_valid, y_train, y_valid):
    model = RandomForestRegressor(n_estimators=10, random_state=0)
    model.fit(X_train, y_train)
    preds = model.predict(X_valid)
    return int(mean_absolute_error(preds, y_valid))

#------------------------
# Verify columns with NaN

missing_val_count_by_column = (X_train.isnull().sum())
print(missing_val_count_by_column[missing_val_count_by_column > 0])

# drop columns alternative (sometimes better)
cols_with_missing = [col for col in X_train.columns if X_train[col].isnull().any()]
#reduced_X_train = X_train.drop(cols_with_missing, axis=1)

# 1) Imputation (replacing NaN with mean value) (fit_transform() trains my_imputer using x_train data, transform doesn't)
my_imputer = SimpleImputer()
imputed_X_train = pd.DataFrame(my_imputer.fit_transform(X_train))
imputed_X_valid = pd.DataFrame(my_imputer.transform(X_valid))

# Imputation removed column names; put them back
imputed_X_train.columns = X_train.columns
imputed_X_valid.columns = X_valid.columns

print("MAE from Approach 1 (Imputation):")
print(score_dataset(imputed_X_train, imputed_X_valid, y_train, y_valid))

# 2) Extension to Imputation

X_train_plus = X_train.copy()
X_valid_plus = X_valid.copy()

for col in cols_with_missing:
    X_train_plus[col + '_was_missing'] = X_train_plus[col].isnull()
    X_valid_plus[col + '_was_missing'] = X_valid_plus[col].isnull()
    
imputed_X_train_plus = pd.DataFrame(my_imputer.fit_transform(X_train_plus))
imputed_X_valid_plus = pd.DataFrame(my_imputer.transform(X_valid_plus))

imputed_X_train_plus.columns = X_train_plus.columns
imputed_X_valid_plus.columns = X_valid_plus.columns

print("MAE from Approach 2 (Extension Imputation):")
print(score_dataset(imputed_X_train_plus, imputed_X_valid_plus, y_train, y_valid))

# Categorical Variables (Non numerical data)

X = melb_predictors
X_train, X_valid, y_train, y_valid = train_test_split(X, y, train_size=0.8, test_size=0.2,random_state=0)

# Get list of categorical variables
object_cols = ['Type', 'Method', 'Regionname']

# 1) Dropping categorical variables
drop_X_train = X_train.drop(columns=object_cols)
drop_X_valid = X_valid.drop(columns=object_cols)

print("MAE from Approach 1 (Drop categorical variables):")
print(score_dataset(drop_X_train, drop_X_valid, y_train, y_valid))

# 2) Ordinal Encoding (convert categories to integers)
label_X_train = X_train.copy()
label_X_valid = X_valid.copy()

ordinal_encoder = OrdinalEncoder()
label_X_train[object_cols] = ordinal_encoder.fit_transform(X_train[object_cols])
label_X_valid[object_cols] = ordinal_encoder.transform(X_valid[object_cols])

print("MAE from Approach 2 (Ordinal Encoding):")
#print(score_dataset(label_X_train, label_X_valid, y_train, y_valid))

#3) One-Hot Encoding

