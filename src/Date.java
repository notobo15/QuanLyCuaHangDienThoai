import java.util.Scanner;

public class Date {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;

    Scanner sc = new Scanner(System.in);

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(int day, int month, int year, int hour, int minute, int second) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public boolean checkYear(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }

        return false;
    }
    public int getDay() {
        return day;
    }

    public void setDay() {
    	System.out.print("Nhap ngay: ");
    	day = Integer.parseInt(sc.nextLine());
    	for(;;){
    		if(checkYear(getYear())) {
    			if(day > 0 && day <= 29 )
    				break;
    			
    		}else {
    			if(day > 0 && day <= 28 )
    				break;
    		}
            System.out.println("Moi nhap lai:");
            day = Integer.parseInt(sc.nextLine());
        }
    	
//        while (true) {
//            try {
//                System.out.print("+ Ngay: ");
//                day = Integer.parseInt(sc.nextLine());;
//                break;
//            } catch (Exception ex) {
//                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! ");
//            }
//        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth() {
    	System.out.print("Nhap thang: ");
    	month = Integer.parseInt(sc.nextLine());
    	for(;;){
            if(month >= 0 && month <= 12)
                break;
            System.out.println("Moi nhap lai:");
            month = Integer.parseInt(sc.nextLine());
        }
//        while (true) {
//            try {
//                do {
//                    System.out.print("+ Thang: ");
//                    month = Integer.parseInt(sc.nextLine());
//                } while (month > 12 || month < 1);
//                break;
//            } catch (Exception ex) {
//                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! ");
//            }
//        }
    }

    public int getYear() {
        return year;
    }

    public void setYear() {
        
        System.out.print("Nhap nam: ");
        year = Integer.parseInt(sc.nextLine());
    	for(;;){
            if(year >= 1900 && year <= 2022)
                break;
            System.out.println("Moi nhap lai:");
            year = Integer.parseInt(sc.nextLine());
        }
//    	while (true) {
//            try {
//                System.out.print("+ Nam: ");
//                year = Integer.parseInt(sc.nextLine());;
//                break;
//            } catch (Exception ex) {
//                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! ");
//            }
//        }
    }
    

//    public void setDay() {
//        while (true) {
//            try {
//                while (true) {
//                    System.out.print("+ Ngay: ");
//                    day = Integer.parseInt(sc.nextLine());
//                    if (checkDay(day)) {
//                        break;
//                    }
//                }
//                break;
//            } catch (Exception ex) {
//                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! ");
//            }
//        }
//    }



    public void setHour() {
        while (true) {
            try {
                do {
                    System.out.print("+ Gio: ");
                    hour = Integer.parseInt(sc.nextLine());
                } while (hour > 23 || hour < 0);
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! ");
            }
        }
    }

    public void setMinute() {
        while (true) {
            try {
                do {
                    System.out.print("+ Phut: ");
                    minute = Integer.parseInt(sc.nextLine());
                } while (minute > 60 || minute < 0);
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! ");
            }
        }
    }

    public void setSecond() {
        while (true) {
            try {
                do {
                    System.out.print("+ Giay: ");
                    second = Integer.parseInt(sc.nextLine());
                } while (second > 60 || second < 0);
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! ");
            }
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime() {
    	setYear();
        setMonth();
        setDay();
    }

    public void setFullDay() {
        setTime();
        setHour();
        setMinute();
        setSecond();
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public String XuatNgay() {
        return day + "/" + month + "/" + year + "-" + hour + ":" + minute + ":" + second;
    }
}
