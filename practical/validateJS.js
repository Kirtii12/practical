function validation(){
   const fname=document.getElementById("fname") 
   const lname=document.getElementById("lname") 
   const form= document.getElementById("form1") 
   const age =document.getElementById("age") 
   const error =document.getElementById("error") 
   const mobile =document.getElementById("mobile") 
   const address = document.getElementById("address") 
   const pattern = /^[A-Z a-z]+$/; 
   const mpatrn = /^([9]{1})-([0-9]{9})$/ 
   const addpatrn = /^[A-Z a-z 0-9]+$/ 
   if(!pattern.test(fname.value))
  { alert("first name should contain alphabate only!!")
  return false
  }if(!pattern.test(lname.value))
  { alert("Last name should contain alphabates only")
  return false
  }if(age.value <= 18 || age.value > 50)
  {
  alert("Age should be between 18 to 50 ")
  return false
  }if(mobile.value.length != 10)
  {
  alert("Mobile number should be of ten numbers")
  return false
  }
  if(!addpatrn.test(address.value))
  { 
    alert("Address does not contains specialcharacter")
     return false
  }
}
  