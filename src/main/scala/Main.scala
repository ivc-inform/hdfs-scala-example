package bleibinhaus.hdfsscalaexample

import java.io._

object Main {
    val testfileName = "testfile.txt"
    val testText = "Example text"

    def main(args: Array[String]): Unit = {
        val testfile = new File(testfileName)
        testfile.delete
        testfile.createNewFile

        val testfileWriter = new BufferedWriter(new FileWriter(testfile))
        testfileWriter.write(testText)
        testfileWriter.close
        HDFSFileService.removeFile(testfileName)
        HDFSFileService.saveFile(testfileName)
        testfile.delete

        val outputStream = new FileOutputStream(new File(testfileName))
        val in = HDFSFileService.getFile(testfileName)
        var b = new Array[Byte](1024)
        var numBytes = in.read(b)
        while (numBytes > 0) {
            outputStream.write(b, 0, numBytes)
            numBytes = in.read(b)
        }
        outputStream.close
        in.close

        val localCheckReader = new BufferedReader(new FileReader(testfileName))
        localCheckReader.close

        testfile.delete
    }
}

