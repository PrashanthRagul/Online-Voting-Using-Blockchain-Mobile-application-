package com.example.voting;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import static java.nio.charset.StandardCharsets.*;
import static java.util.Base64.getEncoder;

public class block implements Serializable {
    private String version;
    private String id;
    private String name;
    private String vote_id;
    private String Time_stamp;
    private String hash;
    private String previousHash;

    public block(String version,String id,String name,String vote_id,String Time_stamp)
    {
        this.version=version;
        this.id=id;
        this.name=name;
        this.Time_stamp=Time_stamp;
        this.vote_id=vote_id;
        this.hash=computeHash();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVote_id() {
        return vote_id;
    }

    public void setVote_id(String vote_id) {
        this.vote_id = vote_id;
    }

    public String getTime_stamp() {
        return Time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        Time_stamp = time_stamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String computeHash() {
        String dataToHash = "" + this.version + this.Time_stamp + this.previousHash + this.id + this.name + this.vote_id;

        MessageDigest digest;
        String encode = null;

     /*   try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash;
            hash = digest.digest(dataToHash.getBytes(UTF_8));
            encode = getEncoder().encodeToString(hash);
*/
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            int i = 0;

            byte[] hash = sha.digest(dataToHash.getBytes("UTF-8"));

            StringBuffer hexHash = new StringBuffer();

            while (i < hash.length) {
                String hex
                        = Integer.toHexString(
                        0xff & hash[i]);
                if (hex.length() == 1)
                    hexHash.append('0');
                hexHash.append(hex);
                i++;
            }

            return hexHash.toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


/*
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.hash = encode;
        return encode;

*/

    }

}




