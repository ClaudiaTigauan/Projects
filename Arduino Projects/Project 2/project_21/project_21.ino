
#include <LiquidCrystal.h>
#include <Keypad.h>
#include <Servo.h>

Servo Servo1;

const byte rows=2;
const byte columns=3;

char hexkeypad[rows][columns]={{'1','2','3'},
                               {'4','5','6'}                    
                              };
byte rPins[rows]={10,9};
byte cPins[columns]={8,7,6};

Keypad kpd = Keypad(makeKeymap(hexkeypad),rPins,cPins,rows,columns);
  
byte i=0;
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

void setup() {

  Servo1.attach(13);
  Serial.begin(9600);
  lcd.begin(16, 2);

  lcd.print("Dozare bile");
}

void loop() {
  
   char keypressed=kpd.getKey();
  Servo1.write(0);
  if(keypressed){
    lcd.setCursor(0, 0);
    lcd.print("Numar bile:");
    lcd.print(keypressed);
    Serial.print("Key pressed is:");
    Serial.println(keypressed);
    Servo1.write(90);
    delay(1000);
  }
}





