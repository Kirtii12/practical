import pandas as pd
import numpy as np
dict={'first score':[100,90,np.nan,95],
 'second score':[30,45,56,np.nan],
 'third score':[np.nan,40,80,98]}
df=pd.DataFrame(dict)
df.head()
df.isnull()
df.notnull()
#df=pd.DataFrame(dict)
df.fillna(0)
df.fillna(method='pad')
df.fillna(method='bfill')
df.replace(to_replace=np.nan,value=-99)
df.dropna()
df.dropna(axis=1)
new_data=df.dropna(axis=0)
new_data
