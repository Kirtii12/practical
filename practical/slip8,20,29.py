import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
%matplotlib inline
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split
from scipy.stats import zscore
import seaborn as sns
data=pd.read_csv('play_tennis.csv')
data.isnull().sum()
data.dtypes
data.head()
data.outlook.value_counts()
from sklearn.preprocessing import LabelEncoder
l=LabelEncoder()
for i in data.columns:
 if data[i].dtypes=='object' or data[i].dtypes=='bool':
 data[i]=pd.Categorical(data[i])
for i in data.columns: 
 data[i]=l.fit_transform(data[i])
data.dtypes
data.head()
x=data.drop(['play'],axis=1)
y=data['play']
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.30,random_state=1)
dtree=DecisionTreeClassifier(criterion='gini',random_state=1)
dtree.fit(x_train,y_train)
print(dtree.score(x_train,y_train)) #data is over fitted so we use max_depth =5 means
prunning technique
print(dtree.score(x_test,y_test))
dtree1=DecisionTreeClassifier(criterion='gini',max_depth=5,random_state=1)
dtree1.fit(x_train,y_train)
print(dtree1.score(x_train,y_train)) #data is over fitted so we use max_depth =5 means 
prunning technique
print(dtree1.score(x_test,y_test))
y_predict=dtree.predict(x_test)
from sklearn import metrics
cm=metrics.confusion_matrix(y_test,y_predict,labels=[1,0])
df_cm=pd.DataFrame(cm,index=[i for i in['1','0']],columns=[i for i in['predicted 1','predicted 
0']] )
df_cm
sns.heatmap(df_cm,annot=True)
from sklearn.metrics import classification_report
m=classification_report(y_test,y_predict)
print(m)