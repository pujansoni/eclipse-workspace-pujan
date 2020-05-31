**Introduction:**
Web search engine are the system which takes input from the user and gives the results according to the string written by the user. In SearchRex, we have used different concepts like converting HTML to text, tokenization, inverted index, edit distance for our search engine. We also used frequency for searching the filtered user input string and compare it to all the TST to filter out the web pages containing the string. User inputs the word to get the information and the string is checked in the stored string dictionary file to return the appropriate search results for the user.

**Technologies used:**
We developed a search engine named SearchRex based on Object Oriented Programming and we used java as our primary programming language to develop this search engine and we used Eclipse IDE for the development of this project. We also used JSoup library of java to convert data used in our project. Apart from Java we also used HTML, CSS, Angular JS and Bootstrap to develop the front end of our project.

System Flow Diagram

**HTML to Text:**
We have used JSOUP for converting HTML files into text files which will be used to search the word and to match the string and the html files are returned as output containing that keyword. JSOUP is a java library used to scrap and parse HTML file or string. JSOUP can find and extract data, using DOM traversal or CSS selectors. JSOUP can also manipulate the HTML elements, attributes, and text. The JSOUP parse() method is used to parse the HTML files. At the end of this step the text files are created in order to search the filtered string given by the user.

**Tokenization:**
A token is the smallest element of a program that is meaningful to the compiler. Whitespaces are used to separate characters and create tokens of the datasets using tokenization. Each word is separated from the text files and stored into different tokens. Tokenization is used in our project to create tokens from text files which will be used to search the keyword written by the user in our data to return the data files based on the input keyword by the user. Trie is a data structure used to store the set of strings, words in text files. TST is created from the tokens to store the strings of each files. Different TST are created for different text files. This data will be used for further concepts to get desired output for our search engine. 

**Inverted Index:**
Inverted index is a concept used to count the frequency of keywords appeared in the file. Data files created as TST will be used by inverted index to count the frequency of keywords appeared in the files written by the user. When user types keyword that keyword will be searched in every TST files and with the help of inverted index concept files containing maximum number of frequencies will be produced. And then with the help of page ranking concept the files containing maximum number of frequencies will be produced as an output. Files will be sorted in Decreasing order of frequency which will help the user to get optimized result for keyword and will get more information on the keyword search. The time complexity to search in inverted index is just 1 since it is a dictionary. But the time complexity to build the inverted index is O(m*n). It is most popular data structure used in document retrieval systems.

**Edit Distance:**
In the SearchRex, search engine we have used edit distance as Spellchecker and it also suggests word. It will recommend the string compared to the input. Edit distance algorithm it will be performed only when the input keyword is not present in the available dataset created by the tokenization. Edit distance, compare the input and keyword from a dataset, then it calculates the minimum distance by performing operations such as insert, delete or update. then it will suggest the nearest keyword to the user. for example, there is no keyword like sear, but a similar word gear is there. which has a minimum edit distance of 1, where the update of character s & g is performed. The time complexity of edit distance algorithm is O(m*n), where m and n are the length of the two strings that will be compared. Edit distance is widely used in computational biology and natural language processing.

**Conclusion:**
We created a web search engine with the help of the concepts we learned in this course to make an efficient and optimized search engine. We have also learned some important algorithms and how to utilize those algorithms and concepts in real world application using object-oriented programming.

**Project Instructions:**
1. Import project as existing maven project
2. In the ServiceCotextClass.java file change htmlpath and textpath to the path where HTML_Files and Text_Files are stored
3. In the GenKeyword.java file change the path of FileReader where stopwords.txt are stored
3. Right click on the project folder and in the drop down list select Maven > Update Project
4. On the Web Content Folder drop down list select homePage.html 
5. Right Click on homePage.html > Run (J2EE Preview at J2EE Prview at localhost Host name: localhost) Run on Server 
6. The Project will run on Chrome if not then by default it will run on eclipse's internal browser

