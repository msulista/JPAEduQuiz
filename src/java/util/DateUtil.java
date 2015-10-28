/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by marcus.rodrigues on 11/04/2015.
 */
public class DateUtil {
    public static boolean verificaData(String data){
        return(data.matches("\\d{2}/\\d{2}/\\d{4}"));
    }
    public static boolean verificaHorario(String horario)
    {
        return(horario.matches("\\d{2}:\\d{2}"));
    }

    public static Date stringToDate(String data) throws ParseException{
        return(new SimpleDateFormat("dd/MM/yyyy").parse(data));
    }

    public static Date stringToDatePostgre(String data){
        SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
        Date d1 = null;
        try {
            d1 = f.parse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        data = format.format(d1);
        Date dataSql = java.sql.Date.valueOf(data);
        return dataSql;
    }

    public static Date stringToHour(String data) throws ParseException{

        return(new SimpleDateFormat("HH:mm").parse(data));
    }
    public static Date stringToHourPostgre(String hora) throws ParseException{
        SimpleDateFormat h = new SimpleDateFormat("HH:mm");
        Date h1 = null;
        h1 = h.parse(hora);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        hora = format.format(h1);
        System.out.println("Hora formatada: " + hora);

        Date horaSql = java.sql.Date.valueOf(hora);
        return horaSql;
    }

    public static Date stringToDateHour(String data) throws ParseException{
        return(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data));
    }

    public static String dateToStringDate(Date data){
        return(new SimpleDateFormat("dd/MM/yyyy").format(data));
    }

    public static String hourToStringHour(Date data){
        return(new SimpleDateFormat("HH:mm").format(data));
    }

    public static String dateHourToString(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataString = formatador.format(data);
        return(dataString);
    }

    public static String hourToString(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        String dataString = formatador.format(data);
        return(dataString);
    }

    public static Date addDays(Date atual, int days){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(atual);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return(calendar.getTime());
    }

    public static long differenceInDays(Date start, Date end){
        long dif = end.getTime() - start.getTime();
        return(Math.abs(dif/(24*60*60*1000)));
    }

    public static String pegaHoraDoSistema(){

        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        calendar.setTime(date);
        String hora = out.format(calendar.getTime());
        return hora;
    }

    public static String pegaDataDoSistema(){

        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        calendar.setTime(date);
        String data = out.format(calendar.getTime());
        return data;
    }
}
