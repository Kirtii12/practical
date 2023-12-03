import pandas as pd 
import numpy as np 
import matplotlib.pyplot as plt 
import seaborn as sns 
#sns.set_style("whitegrid")
#plt.style.use("fivethirtyeight")
USAhousing = pd.read_csv('USA_Housing.csv') 
USAhousing.head() 
X = USAhousing[['Avg. Area Income', 'Avg. Area House Age', 'Avg. Area 
Number of Rooms', 
 'Avg. Area Number of Bedrooms', 'Area Population']] 
y = USAhousing['Price'] 
from sklearn.model_selection import train_test_split 
X_train, X_test, y_train, y_test = train_test_split(X, y, 
test_size=0.4, random_state=101) 
from sklearn.linear_model import LinearRegression 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
lin_reg = LinearRegression(normalize=True) 
lin_reg.fit(X_train,y_train) 
pred = lin_reg.predict(X_test) 
plt.scatter(y_test, pred) 
plt.show() 