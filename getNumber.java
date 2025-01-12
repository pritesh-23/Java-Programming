public int getNumber(int num , String type) {
if(type.equalsIgnoreCase("byte")){
return getByte(num) ;
}
if(type.equalsIgnoreCase("Short")) {
return getShort(num) ;
}
return 0 ;
}

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

