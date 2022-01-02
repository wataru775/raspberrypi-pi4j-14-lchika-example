package org.mmpp.raspberrypi.pi4j;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LChika14 {
    public static void main(String[] args) {
        System.out.println("LChika Start");
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "MyLED", PinState.HIGH);

        // set shutdown state for this pin
        led.setShutdownOptions(true, PinState.LOW);


        try{
            System.out.println("LED high");
            led.high();
            Thread.sleep(1000);
            System.out.println("LED low");
            led.low();
            Thread.sleep(1000);

            System.out.println("LED high");
            led.high();
            Thread.sleep(2000);
            System.out.println("LED low");
            led.low();
            Thread.sleep(1000);

            System.out.println("LED high");
            led.high();
            Thread.sleep(3000);
            System.out.println("LED low");
            led.low();
            System.out.println("LChika END");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gpio.shutdown();


    }
}
