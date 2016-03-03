package com.fangshuai;

import com.hero.HeroAttribute;

import java.io.*;

/**
 * Created by Fansghuai on 2016/1/27.
 */
public class Add2ListHero {
    public static void main(String[] args) throws IOException {
        HeroAttribute.HeroList.Builder builder = HeroAttribute.HeroList.newBuilder();
        HeroAttribute.Hero.Builder hero = HeroAttribute.Hero.newBuilder();
        hero.setId(1).setName("haha").setLevel(13).setFight(55).setRoleType(HeroAttribute.Hero.RoleType.WARRIOR);
        HeroAttribute.Hero.UniqueSystem.Builder uniquesystem = HeroAttribute.Hero.UniqueSystem.newBuilder();
        uniquesystem.setHores(1);
        uniquesystem.setWings(1);
        hero.setUniqueSystem(uniquesystem);

        File file = new File("text");
        FileOutputStream output = new FileOutputStream(file);
        builder.addHero(hero).build().writeTo(output);
        output.close();
        FileInputStream input = new FileInputStream(file);
        HeroAttribute.HeroList heroList = HeroAttribute.HeroList.parseFrom(input);
        HeroAttribute.Hero hero1 = heroList.getHero(0);
        System.out.print(hero1.getId() + " " + hero1.getName() + " " + hero1.getLevel() + " " + hero1.getFight());
    }


}
