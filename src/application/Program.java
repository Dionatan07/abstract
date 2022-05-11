package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = teclado.nextInt();

        List<TaxPayer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char response = teclado.next().charAt(0);
            System.out.print("Name: ");
            teclado.nextLine();
            String name = teclado.nextLine();

            System.out.print("Anual income: ");
            double anualIncome = teclado.nextDouble();

            if (response == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = teclado.nextDouble();

                list.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = teclado.nextInt();

                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID: ");
        double sum = 0.0;
        for (TaxPayer tp : list) {
            System.out.print(tp.getName() + ": $ " + String.format("%.2f%n", tp.tax()));
            sum += tp.tax();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: " + String.format("%.2f", sum));


    }
}
