import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
%matplotlib inline
import seaborn as sns
data=pd.read_csv('pima-indians-diabetes.csv')
data.shape
data.isnull().sum()
data.isnull().values.any()
data.dtypes
#visualisation
data.hist()
columns=list(data)[0:-1]
data[columns].hist()
#identifty the correlation
data.corr()
sns.heatmap(data.corr(),annot=True)
sns.pairplot(data)
#calculate diabetes ratio of true or false target varible
n_true=len(data.loc[data['class']==True])
n_false=len(data.loc[data['class']==False])
print("No.of true cases:{0} {1}%".format(n_true,(n_true/(n_true+n_false))*100))
print("No.of false cases:{0} {1}%".format(n_false,(n_false/(n_true+n_false))*100))
#split the data
from sklearn.model_selection import train_test_split
x=data.drop('class',axis=1)
y=data['class']
X_train,X_test,Y_train,Y_test=train_test_split(x,y,test_size=0.30,random_state=1)
from sklearn.impute import SimpleImputer
rep_0=SimpleImputer(missing_values=0,strategy='mean')
cols=X_train.columns
X_train=pd.DataFrame(rep_0.fit_transform(X_train))
X_test=pd.DataFrame(rep_0.fit_transform(X_test))
X_train.columns=cols
X_test.columns=cols
X_train.head()
from sklearn.naive_bayes import GaussianNB
diab_mode=GaussianNB()
diab_mode.fit(X_train,Y_train)
diab_train_predict=diab_mode.predict(X_train)
from sklearn import metrics
print("Model Accuracy:{0}".format(metrics.accuracy_score(Y_train,diab_train_predict)))
diab_train_predict=diab_mode.predict(X_test)
from sklearn import metrics
print("Model Accuracy:{0}".format(metrics.accuracy_score(Y_test,diab_train_predict)))
cm1=metrics.confusion_matrix(Y_test,diab_train_predict,labels=[1,0])
df_cm1=pd.DataFrame(cm1,index=[i for i in['1','0']],columns=[i for i in['predict 1','predict 
o']] )
df_cm1
