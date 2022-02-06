#include <LiquidCrystal.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

int inputPin = 9;               
int pirState = LOW;             
int val = 0; 
int pos = 0;

int sensePin = A2;  
int sensorInput;    
double temp;
int s,m,h;

void setup()
{
  pinMode(A0, INPUT);
  pinMode(8, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(12, OUTPUT);
  pinMode(13, OUTPUT);
  lcd.begin(16, 2);
  
   pinMode(inputPin, INPUT);  
   Serial.begin(9600);
    
}

void loop()
{
  
  sensorInput = analogRead(A2);        //read the analog sensor and store it
  temp = (double)sensorInput / 1024;   //find percentage of input reading
  temp = temp * 5;                     //multiply by 5V to get voltage
  temp = temp - 0.5;                   //Subtract the offset 
  temp = temp * 100;
  Serial.print("Temperature = ");
  Serial.println(temp);
  
     if (digitalRead(A0) == HIGH)
   {
      lcd.setCursor(0, 1);
      lcd.print("Dezinfecteaza-te");
     tone(8, 200, 500); 
     delay(1000);
     
   }
  else {
    
    lcd.clear();
  }
  
   
   
  if (digitalRead(A1) == HIGH ) {
  }
  delay(10); 
  
  val = digitalRead(inputPin);  
  
  if (temp > 37.5 && temp < 42 && val == HIGH) 
  {
   tone(8, 700, 1000); 
    lcd.print("Suspect COVID");
    lcd.setCursor(0, 1);
    lcd.print("in jur!!");
    delay(1000);
     lcd.clear();
  }
 
  
 else if (val == HIGH) {            
    lcd.print("Patreaza");
    lcd.setCursor(0, 1);
    lcd.print("distanta!");
    tone(8, 600, 500); 
  
    delay(1000);
    
    lcd.clear();
    
   
    
    if (pirState == LOW) {
      Serial.println("Motion detected!");
      pirState = HIGH;
    }
  } else {
   
    if (pirState == HIGH){
      
     Serial.println("Motion ended!");
      pirState = LOW;
    }
  }
  
 
   s=millis()/ 1000;
   m=s/60;
  	h=m/60;
	s=s%60;
   m=m%60;
  h=h%24;
   
   if(s==59)
   {
     lcd.setCursor(0, 1);
      lcd.print("Dezinfecteaza-te");
     tone(8, 200, 500); 
     delay(1000);
     
   }
  
  lcd.print(h);
  lcd.print(":");
  lcd.print(m);
  lcd.print(":");
  lcd.print(s);
  delay(1000);
  
  
}