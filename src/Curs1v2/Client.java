package Curs1v2;

import Curs1.Abonement;
import Curs1.FitnessZone;
import Curs1.TypeAbon;
import Curs1.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Client
{
    private Curs1.FitnessZone zone;        //�������� ����
    private Abonement abonement;     //��������� �������
    public Client(
            FitnessZone zone, TypeAbon typeAbon,
            LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate,
            LocalDate currentDate, LocalTime currentTime
                 )
    {
        if(zone == null)
        {
            throw new IllegalArgumentException("���� ���������� �� ����������");
        }
        if(typeAbon == null)
        {
            throw new IllegalArgumentException("���� ���������� �� ����������");
        }
        if(beginDate == null)
        {
            throw new IllegalArgumentException("�������������� �������� ���� ������ ����������!");
        }
        if(endDate == null)
        {
            throw new IllegalArgumentException("�������������� �������� ���� ��������� ����������!");
        }
        if(birthDate == null)
        {
            throw new IllegalArgumentException("�������������� �������� ���� �������� ����������!");
        }
        if(!beginDate.isBefore(endDate))
        {
            throw new IllegalArgumentException("���� ��������� ���������� ������ ���� ������!");
        }
        if(currentDate == null)
        {
            throw new IllegalArgumentException("��� ���� ������� ����������");
        }
        if(currentTime == null)
        {
            throw new IllegalArgumentException("��� ������� ������� ����������");
        }
        this.zone = zone;
        switch (typeAbon)
        {
            case DAILY:
                abonement = new DailyAbon(beginDate,endDate,customer,birthDate);
                break;
            case FULL:
                abonement = new FullAbon(beginDate,endDate,customer,birthDate);
                break;
            case SHOT:
                abonement = new ShotAbon(beginDate,endDate,customer,birthDate);
                break;
        }
    }
}
