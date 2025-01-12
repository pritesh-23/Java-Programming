//positive number code
public int getByte(int num){
int temp = num/128 ;
int result ;

if(temp%2 == 0) {
result = num%128 ;
}
else
{
result = -128 + num % 128 ;
}
return result ;
}

//Negative 
public int getByte(int num) 
{
int temp = num/128 ;
int result ;

if(temp  %  2 == 0 ) 
{
result = num % 128 ;
}
else 
{
if(num<0){
result = 128 + num % 128;
}else{
result = -128 + num % 128 ;
}
}
return result ;
} 
