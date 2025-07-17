using System;
using System.Linq;
using System.IO;

public class Q1546 {

    public static void Main(string[] args) {
        
        int count = int.Parse(Console.ReadLine()); // 미사용
        
        double[] scores = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();
        double max = scores.Max();
        double average = scores.Select(score -> score / max * 100).Average();

        Console.Write(average);
    }
}