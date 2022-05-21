public class Digital_Watch {
    enum states{NORMAL,UPDATE,ALARM}
    enum display_states {DATE,TIME}
    enum alarm_states {Alarm,Chime}
    enum update_states {min,hour,day,month,year}
    states state = states.NORMAL;
    display_states display_state = display_states.TIME;
    alarm_states alarm_state = alarm_states.Alarm;
    update_states update_state = update_states.min;
    int m=0,h=0,D=1,M=1,Y=2000;

    public void press_a_button(){
        switch (state){
            case NORMAL:
                if(display_state == display_states.TIME){
                    display_state = display_states.DATE;
                }else{
                    display_state = display_states.TIME;
                }
                break;
            case ALARM:
                alarm_state = alarm_states.Chime;
                break;
            case UPDATE:
                switch(update_state){
                    case min:
                        update_state=update_states.hour;
                        break;
                    case hour:
                        update_state=update_states.day;
                        break;
                    case day:
                        update_state=update_states.month;
                        break;
                    case month:
                        update_state=update_states.year;
                        break;
                    case year:
                        state = states.NORMAL;
                        display_state = display_states.TIME;
                        break;
                }
                break;
        }
    }

    public void press_b_button(){
        switch (state){
            case NORMAL:
                state = states.ALARM;
                alarm_state=alarm_states.Alarm;
                break;
            case ALARM:
                //do nothing
                break;
            case UPDATE:
                switch(update_state){
                    case min:
                        increment_min();
                        break;
                    case hour:
                        increment_hour();
                        break;
                    case day:
                        increment_day();
                        break;
                    case month:
                        increment_month();
                        break;
                    case year:
                        increment_year();
                        break;
                }
                break;
        }
    }

    public void press_c_button(){
        switch (state){
            case NORMAL:
                state = states.UPDATE;
                update_state = update_states.min;
                break;
            case ALARM:
                //do nothing
                break;
            case UPDATE:
                //do nothing
                break;
        }
    }

    public void press_d_button(){
        switch (state){
            case NORMAL:
                //do nothing
                break;
            case ALARM:
            case UPDATE:
                state=states.NORMAL;
                display_state = display_states.TIME;
                break;
        }
    }

    public void DisplayDate(){
        System.out.println(Y+"-"+M+"-"+D);
    }
    public void DisplayTIME(){
        System.out.println(h+":"+m);
    }
    private void increment_min(){
        if(m==59){
            m=0;
            //increment_hour();                       //uncomment this if you want it to automatically update
        }else{
            m++;
        }
    }
    private void increment_hour(){
        if(h==23){
            h=0;
            //increment_day();                        //uncomment this if you want it to automatically update
        }else{
            h++;
        }
    }
    private void increment_day(){
        switch (m){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(D==31){
                    D=1;
                    //increment_month();              //uncomment this if you want it to automatically update
                }else{
                    D++;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if(D==30){
                    D=1;
                    //increment_month();              //uncomment this if you want it to automatically update
                }else{
                    D++;
                }
                break;
            case 2:
                if ((Y%100==0&&Y%400==0)||(Y%100!=0&&Y%4==0)){      //condition for leap years
                    if(D==29){
                        D=1;
                        //increment_month();          //uncomment this if you want it to automatically update
                    }else{
                        D++;
                    }
                }else{
                    if(D==28){
                        D=1;
                        increment_month();          //uncomment this if you want it to automatically update
                    }else{
                        D++;
                    }
                }
                break;
        }
    }
    private void increment_month(){
        if (m==12){
            m=1;
            //increment_year();                       //uncomment this if you want it to automatically update
        }else{
            m++;
        }
    }
    private void increment_year(){
        Y++;
    }
}
