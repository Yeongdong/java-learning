# I/O 기본2 정리

* 기본(기반, 메인) 스트림
    * File, 메모리, 콘솔 등에 직접 접근하는 스트림
    * 단독으로 사용 가능
    * 예) FileInputStream, FileOutputStream, FileReader, FileWriter, ByteArrayInputStream, ByteArrayOutputStream
* 보조 스트림
    * 기본 스트림을 도와주는 스트림
    * 단독으로 사용 불가, 반드시 대상 스트림이 있어야 함
    * 예) BufferedInputStream, BufferedOutputStream, InputStreamReader, OutputStreamWriter, DataOutputStream,
      DataInputStream, PrintStream