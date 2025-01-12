//positive number code
public int getShort(int num){
int temp = num/32768 ;
int result ;

if(temp%2 == 0) {
result = num%32768 ;
}
else
{
result = -32768 + num % 32768 ;
}
return result ;
}

//Negative 
public int getShort(int num) 
{
int temp = num/32768 ;
int result ;

if(temp  %  2 == 0 ) 
{
result = num % 32768 ;
}
else 
{
if(num<0){
result = 32768 + num % 32768;
}else{
result = -32768 + num % 32768 ;
}
}
return result ;
} 

