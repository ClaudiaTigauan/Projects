
#include <Servo.h>

int val;
Servo servo_9;

double temp;
int sensorInput; 

void setup()
{
  servo_9.attach(9);
  
   Serial.begin(9600);
   pinMode(A2, INPUT);
}

void loop()
{
  val=analogRead(1);
  val=map(val,0,1023,0,180);
  servo_9.write(val);
  delay(15);
  
  sensorInput = analogRead(A2);        //read the analog sensor and store it
  temp = (double)sensorInput / 1024;   //find percentage of input reading
  temp = temp * 5;                     //multiply by 5V to get voltage
  temp = temp - 0.5;                   //Subtract the offset 
  temp = temp * 100;
  Serial.print("Temperature = ");
  Serial.println(temp);
  
  if(temp>25)
  {
    digitalWrite(4,HIGH);
    delay(100);
  }
  else{
    digitalWrite(4,LOW);
    delay(100);
  }
  
}