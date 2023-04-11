package Curs1v2;

import java.time.LocalDate;

public  class Abonement
{
    private LocalDate beginDate;         //���� ������ ����������
    private LocalDate endDate;           //���� ����� ����������
    private String customer;            //��� ����������
    private LocalDate birthDate;     //���� �������� ����������
    protected Abonement(LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate)
    {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.customer = customer;
        this.birthDate = birthDate;
    }

    protected void add(Abonement [] arr, LocalDate currentDate)
    {
        if(arr == null)
        {
            throw new IllegalArgumentException("�������� ������ �� ������");
        }
        if(currentDate == null)
        {
            throw new IllegalArgumentException("�������� ������ �� ������� ����");
        }
        if (!beginDate.isBefore(currentDate) || !endDate.isAfter(currentDate))
        {
            System.out.println("��������� ���������");
            throw new IllegalArgumentException("��������� ���������");
        }
        for (int i = 0; i < arr.length; i++)
        {
            if(i == arr.length - 1 && arr[i] != null)
            {
                throw new IllegalArgumentException("���� ���!");
            }
            if(arr[i] == null)
            {
                arr[i] = this;
            }
        }
    }
}
