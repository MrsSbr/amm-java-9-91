package entity;

import logic.IdPK;
import logic.TableName;

@TableName(name = "Philosopher")
public record Philosopher(@IdPK int id, String philosopherName, String workName, String genre, int yearOfCreation, double rating) {

}