package com.amuxika.googlelogin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*************************************************************************************************
 * Created by anartzmugika on 5/10/16.
 */
public class UpdateDataManage {

    public static boolean isPassOneHour(String pass)
    {

        //Get curren data time
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String current = dateFormat.format(date);

        //Extract current data time all values

        int current_year = Integer.parseInt(current.substring(0, 4));
        int current_month = Integer.parseInt(current.substring(5,7))-1;
        int current_day = Integer.parseInt(current.substring(8,10));

        int current_hour = Integer.parseInt(current.substring(11,13));
        int current_minute = Integer.parseInt(current.substring(14,16));
        int current_seconds = Integer.parseInt(current.substring(17));

        //String pass = "2016-10-05 10:14:00";

        //Extract last update data (pass from parameter

        int year = Integer.parseInt(pass.substring(0, 4));
        int month = Integer.parseInt(pass.substring(5,7))-1;
        int day = Integer.parseInt(pass.substring(8,10));

        int hour = Integer.parseInt(pass.substring(11,13));
        int minute = Integer.parseInt(pass.substring(14,16));
        int seconds = Integer.parseInt(pass.substring(17));


        System.out.println("CURRENT: " + current_year+"/"+current_month+"/"+current_day+" "+current_hour+":"+current_minute+":"+current_seconds);

        System.out.println("PASS: " + year+"/"+month+"/"+day+" "+hour+":"+minute+":"+seconds);

        if (current_year == year)
        {
            if (current_month == month)
            {
                if (current_day == day)
                {
                    if (current_hour > hour)
                    {
                        if ((current_hour - hour > 1))
                        {
                            //Bi ordu gutxienez
                            System.out.println("Bi ordu gutxienez: " + (current_hour) +  " / " + hour);
                            return true;
                        }
                        else
                        {
                            if (((current_minute + 60) - minute ) < 60)
                            {
                                //Ordu barruan dago
                                System.out.println("Ordu barruan nago ez delako 60 minutu pasa: " + ((current_minute + 60) - minute ));
                                return false;
                            }
                            else
                            {
                                //Refresh
                                System.out.println("Eguneratu, ordu bat pasa da gutxienez: " + ((current_minute + 60) - minute ));
                                return true;
                            }
                        }

                    }
                }
            }
        }
        return false;
    }
}
