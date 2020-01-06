package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    //Atributos
    private String speciality;


    //Constructor
    public Doctor(String name, String mail) {
        // TODO Auto-generated constructor stub
        super(name, mail);
    }

    //Metodos
    public void showName() {
        System.out.println(getName());
    }
    public void showAll() {
        System.out.println("name: "+ getName() + " speciality: " + speciality);
    }

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(String date, String time){

        availableAppointments.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }
    @Override
    public String toString(){
        return super.toString() + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital Cruz roja");
        System.out.println("Departamento Cancerología");
    }


    public class AvailableAppointment{
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

       public Date getDate() {
            return date;
        }

        public String getDate(String DATE) {
            return format.format(date);

        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString(){
            return "Available Appointments \n Date:" +date+ "\nTime: " + time;
        }
    }

}
