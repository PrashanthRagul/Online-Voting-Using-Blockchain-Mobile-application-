package com.example.voting;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.StrictMath.max;

public class Blockchain implements Serializable {

    private List<block> chain;

    public Blockchain() {
        chain = new ArrayList<block>();
        chain.add(generateGenesis());
    }

    private block generateGenesis() {
        block genesis = new block("0x222", "0", "null", "null", "null");
        genesis.setPreviousHash(null);

        genesis.computeHash();

        return genesis;
    }

    public void addBlock(block blk) {
        block newblock = blk;
        newblock.setPreviousHash(chain.get(chain.size() - 1).getHash());
        newblock.computeHash();
        this.chain.add(newblock);
    }

    public void displayChain() {
        for (int i = 0; i < chain.size(); i++) {
            System.out.println("Block :" + i);
            System.out.println("Version :" + chain.get(i).getVersion());
            System.out.println("ID :" + chain.get(i).getId());
            System.out.println("Name :" + chain.get(i).getName());
            System.out.println("Date :" + chain.get(i).getTime_stamp());
            System.out.println("Voted :" + chain.get(i).getVote_id());
            System.out.println();
        }
    }

    public Boolean isValid() {
        int a = 1;
        for (int i = chain.size() - 1; i > 0; i--) {
            if (!chain.get(i).getHash().equals(chain.get(i).computeHash())) {
                a--;
                return false;
               // System.out.println("Chain not valid");
               // break;

            }
            if (!chain.get(i).getPreviousHash().equals(chain.get(i - 1).computeHash())) {
                a--;
                return false;
                //System.out.println("Chain not valid");
                //break;
            }

        }
        //if (a == 1)
            return true;
//return false;
    }

    public block getLatestBlock() {
        return this.chain.get(chain.size() - 1);
    }

    public String getUser(String id) {

        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).getId().equals(id)) {
              /*  System.out.println("Block :"+i);
                System.out.println("Version :"+chain.get(i).getVersion());
                System.out.println("ID :"+chain.get(i).getId());
                System.out.println("Name :"+chain.get(i).getName());
                System.out.println("Voted :"+chain.get(i).getVote_id());
                System.out.println("End Date :"+chain.get(i).getTime_stamp());

             */
                return chain.get(i).getVote_id();
            }
        }

        return "NOT FOUND";

    }
public Boolean Voted(String name)
{
    for (int i = 0; i < chain.size(); i++) {
        if (chain.get(i).getName().equals(name)) {

            return true;
        }
        }
    return false;
}
    public String result() {
        HashMap<String, Integer> map = new HashMap<>();
        int m = 0;
        for (int i = 0; i < chain.size(); i++) {
            String party = chain.get(i).getVote_id();
            if (map.containsKey(party)) {

                map.put(party, map.get(party) + 1);
            } else {

                map.put(party, 1);
            }
            m = max(m, map.get(party));

        }
        String h = "";
        for (String i : map.keySet()) {
            if (map.get(i) == m) {
                h = i;
                break;
            }
        }

        return h;
    }


    public String findpercent() {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < chain.size(); i++) {
            String party = chain.get(i).getVote_id();
            if (map.containsKey(party)) {

                map.put(party, map.get(party) + 1);
            } else {

                map.put(party, 1);
            }
        }

        int m =chain.size()-1;

        String h = "";
       /* for (String i : map.keySet()) {
            m = m+map.get(i);
            }
*/

        h=h+String.valueOf((map.get("A")*100)/m)+','+String.valueOf((map.get("B")*100)/m)+','+String.valueOf((map.get("C")*100)/m)+','+String.valueOf((map.get("D")*100)/m);

        return h;
    }



}







