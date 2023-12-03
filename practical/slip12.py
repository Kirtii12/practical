import pandas as pd
#load Iris data set
iris = pd.read_csv('Iris.csv')
iris.head()
iris['code']=pd.factorize(iris.Species)[0]
iris.tail()
iris.code.value_counts()