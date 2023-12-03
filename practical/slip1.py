import pandas as pd 
import matplotlib.pyplot as plt 
iris=pd.read_csv("Iris.csv") 
iris.plot(kind="scatter",x='SepalLengthCm',y='PetalLengthCm') 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
plt.grid() 
plt.show()