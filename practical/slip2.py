# importing pandas as pd 
import pandas as pd 
# importing numpy as np 
import numpy as np 
# dictionary of lists 
dict = {'First Score':[100, 90, np.nan, 95], 
 'Second Score': [30, 45, 56, np.nan], 
 'Third Score':[np.nan, 40, 80, 98]} 
# creating a dataframe from list 
df = pd.DataFrame(dict) 
# using isnull() function
print("\n isnull() function ");
print(df.isnull()) 
# filling missing value using fillna()
print("\n After filling null values with 0");
print(df.fillna(0)) 