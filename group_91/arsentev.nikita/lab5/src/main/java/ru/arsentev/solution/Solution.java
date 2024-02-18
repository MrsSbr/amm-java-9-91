package ru.arsentev.solution;

public class Solution {
    public static void main(String[] args) {
        System.out.println("CHECK SERIALIZE");
        CheckSerializeSolution.checkTemplateSerializeJsonObjectMethod();
        CheckSerializeSolution.checkTemplateSerializeJsonManualMethod();
        CheckSerializeSolution.checkCatSerializeJsonStdCatMethod();
        CheckSerializeSolution.checkTemplateMySerializeJsonMethod();
        System.out.println("CHECK DESERIALIZE");
        CheckDeserializeSolution.checkTemplateDeserializeMethod();
        CheckDeserializeSolution.checkCatDeserializeJsonStdCatMethod();
        CheckDeserializeSolution.checkCatDeserializeBuilderMethod();
    }
}
