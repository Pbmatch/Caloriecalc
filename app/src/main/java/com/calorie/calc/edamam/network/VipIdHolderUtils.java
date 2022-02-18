package com.calorie.calc.edamam.network;



public class VipIdHolderUtils {

   /*final static private String FILE_NAME="green.dat";
    final static  private String CHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  public static VipStatus getVipId(Context context)
  {
      VipStatus id = getVipPrefences(context);
     if(id!=null&&id.getDevice()!=null&&id.getDevice().length()>4)
       return id;
     else
         {
             id=  getFromFile(context);
             if(id!=null&&id.getDevice()!=null&&id.getDevice().length()>4)
                 return id;
             return null;
     }

  }
    public static void saveVipToPrefs(VipStatus vipStatus, Context context)
  {
      SharedPreferences defaultPreferences = PreferenceManager.getDefaultSharedPreferences(context);
      SharedPreferences.Editor prefsEditor = defaultPreferences.edit();
      Gson gson = new Gson();
      String json = gson.toJson(vipStatus);
      prefsEditor.putString(Constants.KEY_VIP_ID, json);
      prefsEditor.commit();

  }


    private static VipStatus getVipPrefences(Context context)
    {
        SharedPreferences defaultPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = defaultPreferences.getString(Constants.KEY_VIP_ID, "");
        VipStatus obj = gson.fromJson(json, VipStatus.class);
        return obj;
    }
    private static VipStatus getFromFile(Context context)
    {
        File file = new File(context.getExternalFilesDir (Environment.DIRECTORY_DOCUMENTS), FILE_NAME);
        if(!file.exists()) return null;
        FileOutputStream fOut = null;
        try {
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            try {
                in.read(bytes);
            } finally {
                in.close();
            }
            String contents = new String(bytes);

            Gson gson = new Gson();
            VipStatus obj = gson.fromJson(contents, VipStatus.class);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
    public static void writeToFile(VipStatus vipStatus, Context context) {

        Gson gson = new Gson();
        String json = gson.toJson(vipStatus);
        File file = new File(context.getExternalFilesDir (Environment.DIRECTORY_DOCUMENTS), FILE_NAME);
        FileOutputStream stream = null;
        try {
            file.createNewFile();
            stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.flush();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
    public static boolean idAvailable(Context context)
    {

        return getVipId(context) != null;

    }
    public static String generateString(int length)
    {
        Random rng=new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = CHAR.charAt(rng.nextInt( CHAR.length()));
        }
        return new String(text);
    }
    public static void updateBase(VipStatus responceVipStatus, int days, boolean status,Context context)
    {
        *//*VipIdHolderUtils.writeToFile(responceVipStatus,context);
        VipIdHolderUtils.saveVipToPrefs(responceVipStatus,context);
        VipState.VipOk vipOk = new VipState.VipOk();
        vipOk.setCode(responceVipStatus.getCode());
        vipOk.setId(responceVipStatus.getDevice());
        vipOk.setNumOfInvited(responceVipStatus.getNumOfInvited());
        vipOk.setDays(days);
        vipOk.setVipStatus(status);
        vipOk.setShowPopup(responceVipStatus.getShowPopup());
        StateAdapter.getVipStateData().postValue(vipOk);
        if(responceVipStatus.getPackageversion()!=null&&responceVipStatus.getPackageversion().length()>3&&!responceVipStatus.getPackageversion().equals(context.getPackageName()))
        {
            StateAdapter.getUpdateNextPackageName().postValue(responceVipStatus.getPackageversion());
        }*//*
    }*/
}
