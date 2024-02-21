package ru.arsentev.solution;

public class Solution {
    public static void main(String[] args) {
        System.out.println("CHECK SERIALIZE");
        System.out.println("///////////////////////////////////////////////////////////");
        CheckSerializeSolution.checkManualSerialize();
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("CHECK DESERIALIZE");
        System.out.println("///////////////////////////////////////////////////////////");
        CheckDeserializeSolution.checkManualDeserializer();
    }
}
