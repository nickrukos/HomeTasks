package Curs1v2;

import java.time.LocalDate;
import java.time.LocalTime;

public  class Abonement
{
    public final String  number;
    public final LocalDate beginDate;         //���� ������ ����������
    public final LocalDate endDate;           //���� ����� ����������
    public final String customer;             //��� ����������
    public final LocalDate birthDate;         //���� �������� ����������
    public final TypeAbon typeAbon;           //��� ����������
    private LocalTime regTime;                //����� ����������� ����������

    public Abonement(String number,LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate, TypeAbon typeAbon)
    {
        this.number = number;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.customer = customer;
        this.birthDate = birthDate;
        this.typeAbon = typeAbon;
    }

    public void setRegTime(LocalTime regTime) {
        this.regTime = regTime;
    }

    public LocalTime getRegTime() {
        return regTime;
    }

    public void add(Abonement [] arr)
    {
        if(arr == null)
        {
            throw new IllegalArgumentException("Wrong point to array");
        }
        for (int i = 0; i < arr.length; i++)
        {
            if(i == arr.length - 1 && arr[i] != null)
            {
                throw new IllegalArgumentException("the area is full!");
            }
            if(arr[i] == null)
            {
                arr[i] = this;
                break;
            }
        }
    }
}
