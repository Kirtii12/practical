import pandas as pd 
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
%matplotlib inline
from sklearn.model_selection import train_test_split
from sklearn import svm
data=pd.read_csv('letterdata.csv')
data.head()
def getaccuracy(testset,prediction):
 correct=0
 for x in range(len(testset)):
 if(testset[x]==prediction[x]):
 correct=correct+1
 return (correct/float(len(testset)))*100.0
data.isnull().values.any()
X,Y=np.array(data)[:,1:16],np.array(data.letter)[:]
X_train=X[:16000,:]
X_test=X[16001:,:]
Y_train=Y[:16000]
Y_test=Y[16001:]
clf=svm.SVC(gamma=0.025,C=3)
clf.fit(X_train,Y_train)
Y_predict=clf.predict(X_test)
getaccuracy(Y_test,Y_predict)
y_g=(np.column_stack([Y_test,Y_predict]))
#column stack used for matching supose x=1,2,3,4,5 and y= 10 20 30 40 match x axis on 1 
check on y axis on 10 ...
print(y_g)
import numpy as np
import matplotlib.pyplot as plt
from sklearn import svm, datasets
# import some data to play with
iris = datasets.load_iris()
X = iris.data[:, :2] # we only take the first two features. We could
# avoid this ugly slicing by using a two-dim dataset
y = iris.target
# we create an instance of SVM and fit out data. We do not scale our
# data since we want to plot the support vectors
C = 1.0 # SVM regularization parameter
svc = svm.SVC(kernel='linear', C=1,gamma=10).fit(X, y)
# create a mesh to plot in
x_min, x_max = X[:, 0].min() - 1, X[:, 0].max() + 1
y_min, y_max = X[:, 1].min() - 1, X[:, 1].max() + 1
h = (x_max / x_min)/100
xx, yy = np.meshgrid(np.arange(x_min, x_max, h),
np.arange(y_min, y_max, h))
plt.subplot(1, 1, 1)
Z = svc.predict(np.c_[xx.ravel(), yy.ravel()])
Z = Z.reshape(xx.shape)
plt.contourf(xx, yy, Z, cmap=plt.cm.Paired, alpha=0.8)
plt.scatter(X[:, 0], X[:, 1], c=y, cmap=plt.cm.Paired)
plt.xlabel('Sepal length')
plt.ylabel('Sepal width')
plt.xlim(xx.min(), xx.max())
plt.title('SVC with linear kernel')
plt.show()
svc = svm.SVC(kernel='rbf', C=1,gamma=10).fit(X, y)
plt.subplot(1, 1, 1)
Z = svc.predict(np.c_[xx.ravel(), yy.ravel()])
Z = Z.reshape(xx.shape)
plt.contourf(xx, yy, Z, cmap=plt.cm.Paired, alpha=0.8)
svc = svm.SVC(kernel='poly', C=1,gamma=100).fit(X, y)
plt.subplot(1, 1, 1)
Z = svc.predict(np.c_[xx.ravel(), yy.ravel()])
Z = Z.reshape(xx.shape)
plt.contourf(xx, yy, Z, cmap=plt.cm.Paired, alpha=0.8)
