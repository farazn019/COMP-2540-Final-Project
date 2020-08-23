

//This might not be needed, if tester.java works fine!
class weeklySchedule{

    public static void main(String[] args){
        scheduleWindow baseWindow = new scheduleWindow();
        baseWindow.addWindow(900, 900);
        baseWindow.setWindowName("Weekly Schedule");
        baseWindow.addDay();

    }
}