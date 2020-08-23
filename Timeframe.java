public class Timeframe implements Comparable<Timeframe> {
    public static class Time implements Comparable<Time>{
        int hour;
        int minute;
        public Time(int hour, int minute){
            this.hour = hour%24;
            this.minute = minute%60;
        }
        public Time(int time[]){
            if(time.length!=2)
                return;
            this.hour = time[0]%24;
            this.minute = time[1]%60;
        }
        @Override
        public int compareTo(Time o) {
            if(o.hour == this.hour) {
                if (o.minute > this.minute)
                    return -1;
                if (o.minute < this.minute)
                    return 1;
                if (o.minute == this.minute)
                    return 0;
            }
            else if (o.hour>this.hour)
                return -1;
            return 1;
        }
    }
    Time startingTime;
    Time endingTime;

    public Timeframe(Time startingTime, Time endingTime) {
        if(startingTime.compareTo(endingTime)!=-1){
            if(this==null)
                System.out.println("NULL");
            return;
        }
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    @Override
    public int compareTo(Timeframe o) {
        return this.endingTime.compareTo(o.startingTime);
    }

    public String toString(){
        return String.format("[%d:%d,%d:%d]",startingTime.hour,startingTime.minute,endingTime.hour,endingTime.minute);
    }
    public static Timeframe toTimeframe(String a){
        String b = a.replaceAll("\\[|\\]","");
        String[] asArray = b.split(":|,");
        return new Timeframe(new Time(Integer.parseInt(asArray[0]),Integer.parseInt(asArray[1])),new Time(Integer.parseInt(asArray[2]),Integer.parseInt(asArray[3])));

    }

    public boolean collide(Timeframe a){
        return !(endingTime.compareTo(a.startingTime)==-1||startingTime.compareTo(a.endingTime)==1);
    }



}