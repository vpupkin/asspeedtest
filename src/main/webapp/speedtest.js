var gesamt=new Array();
function Ajax()
{
  for(var i=1;i<9;i++)
  {
         proceedAjaxRequest(i);
  } 
}

function proceedAjaxRequest(num)
{  
  var xmlHttp;
  var sizeArray=new Array(32,64,128,256,512,1024,2048,4096);
  try
    {    // Firefox, Opera 8.0+, Safari   
        xmlHttp=new XMLHttpRequest();
     }
  catch (e)
    {    // Internet Explorer
     try
      {      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");      }
    catch (e)
      {      try
        {        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");        }
      catch (e)
        {        alert("Your browser does not support AJAX!");
                 return false;        
        }
       }      
     }    
      
       
      xmlHttp.onreadystatechange=function(){
      if((xmlHttp.readyState==4))
        {
            var now2=new Date();
            var time2=now2.getTime();
            var time=(time2-time1)/1000;
            var speed=calcSpeed(sizeArray[num-1],time);
            var element=document.getElementById('text');
            
            element.appendChild(document.createTextNode("Zeit: "+time.toFixed(3)+" sek Dateigröße: "+sizeArray[num-1]+" KB  Geschwindigkeit  "+speed.toFixed(1)+" KB/sek"));
            element.appendChild(document.createElement('br'));
            gesamtSpeed(num-1,speed);
            
            
        }
      }
     xmlHttp.open("POST","/SpeedTest/SpeedTest?cmd="+num,true);
     var now=null;
     now=new Date();
     var time1=now.getTime();
     xmlHttp.send(null); 
      return true; 
}
function calcSpeed(size,time)
{
    if(time==0)
    {
       return 0;
    }
    else
    {
      return size/time;
    }
}

function gesamtSpeed(i,speed)
{
    gesamt[i]=speed;
    var g=0;
    if(gesamt.length=="8")
    {
       for(var x=0;x<8;x++)
       {
           g+=gesamt[x];
       }
       var avg=g/8;
       var element=document.getElementById('text');
       element.appendChild(document.createElement('br'));
       element.appendChild(document.createTextNode("Durchschnittsgeschwindigkeit kb/sek: "+avg.toFixed(2)));
       element.appendChild(document.createElement('br'));
       gesamt=new Array();
       zaehler=0;
       
    }
}
