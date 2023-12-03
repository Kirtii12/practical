import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
iris = pd.read_csv("Iris.csv") # Reading the dataset “Iris.csv”.
print (iris.head(10)) # head() will display the top rows of the dataset, the 
default value of this function is 5,
#that is it will show top 5 rows when no argument is given to it.
plt.plot(iris.Id, iris["SepalLengthCm"],"r--")
plt.show #plt.show () will display the current figure that you are working on
iris.plot(kind ="scatter", x ='SepalLengthCm', y ='PetalLengthCm')
plt.grid() # grid () function to add grid lines to the plot