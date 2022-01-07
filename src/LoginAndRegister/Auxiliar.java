package LoginAndRegister;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import swing.WrapLayout;


public class Auxiliar extends javax.swing.JPanel {

    public Auxiliar() {
        initComponents();
        panel_central.setLayout(new WrapLayout(WrapLayout.LEADING));
    }
    
    Books bi;
    
    public class Library {

        private final int t;
        private Books aux = new Books();

        public Books getAux() {
            return aux;
        }

        public void setAux(Books aux) {
            this.aux = aux;
        }

        public class Shelve{

            public int n;
            Books key[] = new Books[2 * t - 1];
            Shelve child[] = new Shelve[2 * t];
            public boolean leaf = true;

            public int Find(int k){

              for(int i =0; i< this.n; i++){
                  if(this.key[i].code == k)
                      return i;
              }
              return -1;
            }; 

            public Books find_title(String title){
                 for(int i =0; i< this.n; i++){
                  if(this.key[i].title.equals(title))
                      return this.key[i];
              }
              return null;
            }

        }
        private Shelve root;

        public Library(int t) {
            this.t = t;
            this.root = new Shelve ();
            this.root.n = 0;
            this.root.leaf = true;
        }

       public  Shelve Search_by_code ( Shelve s, int key){

           int i;
           if(s == null)
               return s;

           for(i=0;i<s.n; i++){
               if(key < s.key[i].code)
                   break;
               if(key == s.key[i].code)
                   this.aux = new Books();
                   this.aux = s.key[i];
                   return s;
           }
           if(s.leaf)
               return null;
           else
               return  Search_by_code(s.child[i], key);
       }


       public Books Search_Book_by_code(int k) {
            if (this.Search_by_code(root, k) != null) {
                if(this.aux.code == k)
                    return this.aux;
            }
            return null;
       }



       public  Shelve search_by_title (Shelve s, String title){

           int i;
           if(s == null)
               return s;

           for(i=0;i<s.n; i++){
               if(title.equals(s.key[i].title)){
                   this.aux = new Books();
                   this.aux = s.key[i];
                   return s;
               }
           }
           if(s.leaf)
               return null;
           else
               return search_by_title (s.child[i], title);
       }


       public Books Search_Book_by_title(String title) {

           Books b = new Books();
            if (this.search_by_title(root, title) != null) {
                if(this.aux.title.equals(title)){
                    
                    
                    
                    bi = new Books();
                    bi = aux;
//                    System.out.println(aux);
//                    System.out.println(b);
                    return b;
                }
            }
            return b;   
       }

       public  Shelve search_by_caegory ( Shelve s, String title){

           int i;
           if(s == null)
               return s;

           for(i=0;i<s.n; i++){
               if(title.equals(s.key[i].category))
                   return s;
           }
           if(s.leaf)
               return null;
           else
               return search_by_title (s.child[i], title);
       }
       
       public boolean Contain_book_category(String category) {
            return this.search_by_title(root, category) != null;
       }
       
       private void split_book(Shelve s, int pos, Shelve aux){

            Shelve z = new Shelve();
            z.leaf = aux.leaf;
            z.n = t - 1;

            for (int j = 0; j < t - 1; j++) {
              z.key[j] = aux.key[j + t];
            }
            if (!aux.leaf) {
              for (int j = 0; j < t; j++) {
                z.child[j] = aux.child[j + t];
              }
            }
            aux.n = t - 1;
            for (int j = s.n; j >= pos + 1; j--) {
              s.child[j + 1] = s.child[j];
            }
            s.child[pos + 1] = z;

            for (int j = s.n - 1; j >= pos; j--) {
              s.key[j + 1] = s.key[j];
            }
            s.key[pos] = aux.key[t - 1];
            s.n = s.n + 1;
       }

       public void Insert_Book(Books b){

           Shelve s = root;
           if(s.n == 2* t-1){
               Shelve aux1 = new Shelve();
               root = aux1;
               aux1.leaf = false;
               aux1.n = 0;
               aux1.child[0] = s;
               split_book(aux1, 0, s);
               insert_book_code(aux1,b);
           }else{
               insert_book_code(s,b);
           }
       }

       private void insert_book_code(Shelve x, Books b) {

        if (x.leaf) {
            int i;
            for (i = x.n - 1; i >= 0 && b.code < x.key[i].code; i--) {
              x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = b;
            x.n = x.n + 1;
        } else {
            
            int i;
            for (i = x.n - 1; i >= 0 && b.code < x.key[i].code; i--) {
            }
            i++;
            Shelve tmp = x.child[i];
            if (tmp.n == 2 * t - 1) {
              split_book(x, i, tmp);
              if (b.code > x.key[i].code) {
                i++;
              }
            }
            insert_book_code(x.child[i], b);
        }

      }

       private void Remove(Shelve x, int key) {

        int pos = x.Find(key);
        if (pos != -1) {
          if (x.leaf) {
                int i;
                for ( i=0; i < x.n && x.key[i].code != key; i++) {
                }
                for (; i < x.n; i++) {
                  if (i != 2 * t - 2) {
                    x.key[i] = x.key[i + 1];
                  }
                }
                x.n--;
                return;
          }
          if (!x.leaf) {

            Shelve pred = x.child[pos];
            Books predKey = new Books();
            if (pred.n >= t) {
                for (;;) {
                  if (pred.leaf) {
                    System.out.println(pred.n);
                    predKey = pred.key[pred.n - 1];
                    break;
                  } else {
                    pred = pred.child[pred.n];
                  }
                }
                Remove(pred, predKey.code);
                x.key[pos] = predKey;
                return;
            }

            Shelve nextNode = x.child[pos + 1];
            if (nextNode.n >= t) {
              Books nextKey = nextNode.key[0];
              if (!nextNode.leaf) {
                nextNode = nextNode.child[0];
                for (;;) {
                  if (nextNode.leaf) {
                    nextKey = nextNode.key[nextNode.n - 1];
                    break;
                  } else {
                    nextNode = nextNode.child[nextNode.n];
                  }
                }
              }
              Remove(nextNode, nextKey.code);
              x.key[pos] = nextKey;
              return;
            }

            int temp = pred.n + 1;
            pred.key[pred.n++] = x.key[pos];
            for (int i = 0, j = pred.n; i < nextNode.n; i++) {
              pred.key[j++] = nextNode.key[i];
              pred.n++;
            }
            for (int i = 0; i < nextNode.n + 1; i++) {
              pred.child[temp++] = nextNode.child[i];
            }

            x.child[pos] = pred;
            for (int i = pos; i < x.n; i++) {
              if (i != 2 * t - 2) {
                x.key[i] = x.key[i + 1];
              }
            }
            for (int i = pos + 1; i < x.n + 1; i++) {
              if (i != 2 * t - 1) {
                x.child[i] = x.child[i + 1];
              }
            }
            x.n--;
            if (x.n == 0) {
              if (x == root) {
                root = x.child[0];
              }
              x = x.child[0];
            }
            Remove(pred, key);
          }
        } else {
            for (pos = 0; pos < x.n; pos++) {
              if (x.key[pos].code > key) {
                break;
              }
            }
            Shelve tmp = x.child[pos];
            if (tmp.n >= t) {
              Remove(tmp, key);
              return;
            }
            if (true) {
              Shelve nb = null;
              Books devider = new Books();
              devider.code = - 1;

              if (pos != x.n && x.child[pos + 1].n >= t) {
                devider = x.key[pos];
                nb = x.child[pos + 1];
                x.key[pos] = nb.key[0];
                tmp.key[tmp.n++] = devider;
                tmp.child[tmp.n] = nb.child[0];
                for (int i = 1; i < nb.n; i++) {
                  nb.key[i - 1] = nb.key[i];
                }
                for (int i = 1; i <= nb.n; i++) {
                  nb.child[i - 1] = nb.child[i];
                }
                nb.n--;
                Remove(tmp, key);
              } else if (pos != 0 && x.child[pos - 1].n >= t) {

                    devider = x.key[pos - 1];
                    nb = x.child[pos - 1];
                    x.key[pos - 1] = nb.key[nb.n - 1];
                    Shelve child = nb.child[nb.n];
                    nb.n--;

                    for (int i = tmp.n; i > 0; i--) {
                      tmp.key[i] = tmp.key[i - 1];
                    }
                    tmp.key[0] = devider;
                    for (int i = tmp.n + 1; i > 0; i--) {
                      tmp.child[i] = tmp.child[i - 1];
                    }
                    tmp.child[0] = child;
                    tmp.n++;
                    Remove(tmp, key);
              } else {
                    Shelve lt;
                    Shelve rt;
                    boolean last = false;
                    if (pos != x.n) {
                      devider = x.key[pos];
                      lt = x.child[pos];
                      rt = x.child[pos + 1];
                    } else {
                      devider = x.key[pos - 1];
                      rt = x.child[pos];
                      lt = x.child[pos - 1];
                      last = true;
                      pos--;
                    }
                    for (int i = pos; i < x.n - 1; i++) {
                      x.key[i] = x.key[i + 1];
                    }
                    for (int i = pos + 1; i < x.n; i++) {
                      x.child[i] = x.child[i + 1];
                    }
                    x.n--;
                    lt.key[lt.n++] = devider;

                    for (int i = 0, j = lt.n; i < rt.n + 1; i++, j++) {
                      if (i < rt.n) {
                        lt.key[j] = rt.key[i];
                      }
                      lt.child[j] = rt.child[i];
                    }
                    lt.n += rt.n;
                    if (x.n == 0) {
                      if (x == root) {
                        root = x.child[0];
                      }
                      x = x.child[0];
                    }
                    Remove(lt, key);
              }
            }
        }
      }

        public void Remove(int key) {
            Shelve x = Search_by_code(root, key);
            if (x == null) {
              return;
            }
            Remove(root, key);
      }

      public void Show() {
          Show(root);
      }

      // Display
      private Books Show(Shelve x) {

        assert (x == null);
        for (int i = 0; x.n >= i; i++){
             return x.key[i];  
        }
        if (!x.leaf) {
          for (int i = 0; i < x.n + 1; i++) {
             Show(x.child[i]);
          }
        }
        return null;
      }

      public void Show_Categorie(String category) {
        Show_Categorie(root,category);
      }

      // Display
      private Books Show_Categorie(Shelve x,String category) {
        assert (x == null);
         for (int i = 0; x.n >= i; i++){
            if(x.key[i].category.equals(category))
                return x.key[i];
        }
        if (!x.leaf) {
          for (int i = 0; i < x.n + 1; i++) {
             Show_Categorie(x.child[i],category);
          }
        }
        return null;
      }
      
    }
    //=======================================================
//    private int mouseX;
//    private int mouseY;
    private final Library Library = new Library(5);  
    private int i;
    private int code = 0;
    
    private int roma = 0;
    private int fict = 0;
    private int adv = 0;
    private int hist = 0;
    private int mist = 0;
    private int cll = 0;

    public Library getLibrary() {
        return Library;
    }

    
    public void addToPanel(book_icon bi){
        panel_central.add(bi);
        panel_central.revalidate();
        panel_central.repaint();    
    }
    
    public void add_ToPanel(book_icon bi){
        panel_central.removeAll();
        panel_central.add(bi);
        panel_central.revalidate();
        panel_central.repaint();    
    }
    
    public void add_all_books_to_panel(){
        Books b = this.Library.Show(this.Library.root);
        if(b != null){
            addToPanel(b.getBi());
        }else{
            System.out.println("B a fost NULL");
        }
    }
   
    private boolean add_book(){
        
        boolean ok = false;
        if(title.getText().equals("") || author.getText().equals("")
                ||sinopse.getText().equals("")|| info.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Please ,compllete all the statements!");      
        }else{
            int returnVal = fileChooser.showOpenDialog(this);
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files","pdf");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            
            if (returnVal == JFileChooser.APPROVE_OPTION){
                 File myfile = fileChooser.getSelectedFile();
                 String path = myfile.getAbsolutePath();
                 path = path.replace('\\','/');
                 String book_category = (String)category.getSelectedItem();
                 Books book = new Books(title.getText(),author.getText(),sinopse.getText(),
                 book_category,info.getText(),code,myfile);                 
                 Library.Insert_Book(book);
                 addToPanel(book.getBi());
                 code++; 
                 if(book_category == "Romance"){
                     roma+=1;
                     rm.setText(String.valueOf(roma));
                 }else if(book_category == "Literary Fiction"){
                    fict+=1;
                    lf.setText(String.valueOf(fict));
                 }else if(book_category == "Action and Adventure"){     
                     adv+=1;
                     aa.setText(String.valueOf(adv));
                 }else if(book_category == "Historical Fiction"){
                     hist+=1;
                     hf.setText(String.valueOf(hist));
                 }else if(book_category == "Detective and Mystery"){
                     mist+=1;
                     dm.setText(String.valueOf(mist));
                 }else{
                         cll+=1;
                         cl.setText(String.valueOf(cll));
                 }
                 ok = true;
             }else{
                System.out.println("File access cancelled by user");
                ok = false;
             }
        }
        this.title.setText("");
        this.author.setText("");
        this.sinopse.setText("");
        this.info.setText("");
        return ok;
    }
    
    private boolean del_book(){
        
        boolean ok = false;
        if(del_title.getText().trim().equals("") || del_title.getText().trim().equals("Book code")){
                 JOptionPane.showMessageDialog(this,"Please ,compllete all the statements!"); 
                 ok = false;
        }else{
            this.Library.Remove(Integer.parseInt(del_title.getText()));
            ok = true;
        }
        return ok;
     }
    
    public boolean search(){
        
        boolean ok = false;
        
        Books book = new Books();
        if(this.search.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please, write the book's name first.");
        else{
            String title1 = this.search.getText().trim();
            book = this.Library.Search_Book_by_title(title1);

            if (book != null){
                //add_ToPanel(book.getBi());
               // this.search.setText("");
               System.out.println(book);
               ok = true;     
            }else{
                System.out.println("null");
            }
        }
        search.setText("");
        return ok;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        barra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_central = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sinopse = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        del_title = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        search_butoon = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        add_Butoon = new javax.swing.JButton();
        del_butoon = new javax.swing.JButton();
        category = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        info = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Romance = new javax.swing.JLabel();
        Classics = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        hf = new javax.swing.JTextField();
        cl = new javax.swing.JTextField();
        dm = new javax.swing.JTextField();
        aa = new javax.swing.JTextField();
        lf = new javax.swing.JTextField();
        rm = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(37, 41, 88));
        jPanel1.setForeground(new java.awt.Color(44, 130, 201));
        jPanel1.setLayout(null);

        barra.setBackground(new java.awt.Color(52, 45, 113));
        barra.setOpaque(true);
        jPanel1.add(barra);
        barra.setBounds(419, -4, 20, 700);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel_central.setBackground(new java.awt.Color(37, 41, 88));

        javax.swing.GroupLayout panel_centralLayout = new javax.swing.GroupLayout(panel_central);
        panel_central.setLayout(panel_centralLayout);
        panel_centralLayout.setHorizontalGroup(
            panel_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        panel_centralLayout.setVerticalGroup(
            panel_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel_central);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(440, 40, 580, 650);

        jLabel2.setBackground(new java.awt.Color(52, 45, 113));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 130, 201));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add a Book");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 420, 35);

        title.setBackground(new java.awt.Color(228, 241, 254));
        title.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });
        jPanel1.add(title);
        title.setBounds(100, 40, 260, 30);

        jLabel3.setBackground(new java.awt.Color(52, 45, 113));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 130, 201));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Title");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 40, 60, 30);

        jLabel4.setBackground(new java.awt.Color(52, 45, 113));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(44, 130, 201));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Author");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 80, 60, 30);

        author.setBackground(new java.awt.Color(228, 241, 254));
        author.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });
        jPanel1.add(author);
        author.setBounds(100, 80, 260, 30);

        jLabel5.setBackground(new java.awt.Color(52, 45, 113));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 130, 201));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sinopse");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 120, 60, 30);

        sinopse.setBackground(new java.awt.Color(228, 241, 254));
        sinopse.setColumns(20);
        sinopse.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        sinopse.setLineWrap(true);
        sinopse.setRows(5);
        jScrollPane2.setViewportView(sinopse);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(100, 120, 260, 50);

        jLabel6.setBackground(new java.awt.Color(52, 45, 113));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(44, 130, 201));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Delete a Book");
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 290, 420, 35);

        jLabel7.setBackground(new java.awt.Color(52, 45, 113));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(44, 130, 201));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Historical Fiction");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 640, 140, 30);

        del_title.setBackground(new java.awt.Color(228, 241, 254));
        del_title.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        del_title.setText("Book code");
        del_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_titleActionPerformed(evt);
            }
        });
        del_title.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                del_titleKeyPressed(evt);
            }
        });
        jPanel1.add(del_title);
        del_title.setBounds(100, 350, 190, 30);

        jLabel9.setBackground(new java.awt.Color(52, 45, 113));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(44, 130, 201));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Number of books by Category");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 480, 420, 30);

        search.setBackground(new java.awt.Color(228, 241, 254));
        search.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        search.setForeground(new java.awt.Color(44, 130, 201));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(30, 440, 317, 31);

        search_butoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-48 (1).png"))); // NOI18N
        search_butoon.setBorder(null);
        search_butoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_butoonActionPerformed(evt);
            }
        });
        jPanel1.add(search_butoon);
        search_butoon.setBounds(350, 440, 33, 32);

        jLabel12.setBackground(new java.awt.Color(52, 45, 113));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(44, 130, 201));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("All Books");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(430, 0, 540, 35);

        jLabel13.setBackground(new java.awt.Color(52, 45, 113));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(44, 130, 201));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Category");
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(40, 180, 60, 25);

        add_Butoon.setBackground(new java.awt.Color(52, 45, 113));
        add_Butoon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add_Butoon.setForeground(new java.awt.Color(44, 130, 201));
        add_Butoon.setText("ADD");
        add_Butoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ButoonActionPerformed(evt);
            }
        });
        jPanel1.add(add_Butoon);
        add_Butoon.setBounds(290, 250, 70, 25);

        del_butoon.setBackground(new java.awt.Color(52, 45, 113));
        del_butoon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        del_butoon.setForeground(new java.awt.Color(44, 130, 201));
        del_butoon.setText("Delete");
        del_butoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_butoonActionPerformed(evt);
            }
        });
        jPanel1.add(del_butoon);
        del_butoon.setBounds(290, 350, 70, 30);

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Action and Adventure", "Literary Fiction", "Detective and Mystery", "Historical Fiction", "Classics" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        jPanel1.add(category);
        category.setBounds(100, 180, 260, 25);

        jLabel10.setBackground(new java.awt.Color(52, 45, 113));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(44, 130, 201));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Detective and Mystery");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(220, 580, 140, 30);

        info.setBackground(new java.awt.Color(228, 241, 254));
        jPanel1.add(info);
        info.setBounds(100, 210, 260, 30);

        refresh.setBackground(new java.awt.Color(52, 45, 113));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/refresh.png"))); // NOI18N
        refresh.setBorder(null);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel1.add(refresh);
        refresh.setBounds(970, 0, 50, 35);

        jLabel11.setBackground(new java.awt.Color(52, 45, 113));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(44, 130, 201));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Check a Book in the Lybrire");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 400, 420, 30);

        jLabel8.setBackground(new java.awt.Color(52, 45, 113));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(44, 130, 201));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Action and Adventure");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 580, 140, 30);

        Romance.setBackground(new java.awt.Color(52, 45, 113));
        Romance.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        Romance.setForeground(new java.awt.Color(44, 130, 201));
        Romance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Romance.setText("Romance");
        Romance.setOpaque(true);
        jPanel1.add(Romance);
        Romance.setBounds(20, 530, 140, 30);

        Classics.setBackground(new java.awt.Color(52, 45, 113));
        Classics.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        Classics.setForeground(new java.awt.Color(44, 130, 201));
        Classics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Classics.setText("Classics");
        Classics.setOpaque(true);
        jPanel1.add(Classics);
        Classics.setBounds(220, 640, 140, 30);

        jLabel16.setBackground(new java.awt.Color(52, 45, 113));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(44, 130, 201));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Literary Fiction");
        jLabel16.setOpaque(true);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(220, 530, 140, 30);

        jLabel18.setBackground(new java.awt.Color(52, 45, 113));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(44, 130, 201));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Title");
        jLabel18.setOpaque(true);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(40, 350, 60, 30);

        hf.setEditable(false);
        jPanel1.add(hf);
        hf.setBounds(160, 640, 32, 30);

        cl.setEditable(false);
        jPanel1.add(cl);
        cl.setBounds(360, 640, 32, 30);

        dm.setEditable(false);
        jPanel1.add(dm);
        dm.setBounds(360, 580, 32, 30);

        aa.setEditable(false);
        jPanel1.add(aa);
        aa.setBounds(160, 580, 32, 30);

        lf.setEditable(false);
        jPanel1.add(lf);
        lf.setBounds(360, 530, 32, 30);

        rm.setEditable(false);
        jPanel1.add(rm);
        rm.setBounds(160, 530, 32, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        
    }//GEN-LAST:event_titleActionPerformed

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed
        
    }//GEN-LAST:event_authorActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void del_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_titleActionPerformed
        
    }//GEN-LAST:event_del_titleActionPerformed

    private void del_titleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_del_titleKeyPressed
        char c = evt.getKeyChar();
        if(Character.isDigit(c) || Character.isISOControl(c)) {
            del_title.setEditable(true);
        } else {
            del_title.setEditable(false);
        }
    }//GEN-LAST:event_del_titleKeyPressed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        
    }//GEN-LAST:event_searchActionPerformed

    private void search_butoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_butoonActionPerformed
        String t = title.getText();
        if(search() == false){
            JOptionPane.showMessageDialog(this,"The searched book wasent found");
        } else {
            add_ToPanel(bi.getBi());
        }
    }//GEN-LAST:event_search_butoonActionPerformed

    private void add_ButoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButoonActionPerformed
        if(add_book()==true){
            JOptionPane.showMessageDialog(this, "Book inserted successfully");
        }else{
            JOptionPane.showMessageDialog(this, "Insertion Failed");
        }
    }//GEN-LAST:event_add_ButoonActionPerformed

    private void del_butoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_butoonActionPerformed
        if(del_book() == true){
            JOptionPane.showMessageDialog(this,"Books Deleted!");
        }
    }//GEN-LAST:event_del_butoonActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        
    }//GEN-LAST:event_categoryActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        panel_central.removeAll();
        add_all_books_to_panel();
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Classics;
    private javax.swing.JLabel Romance;
    private javax.swing.JTextField aa;
    private javax.swing.JButton add_Butoon;
    private javax.swing.JTextField author;
    private javax.swing.JLabel barra;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JTextField cl;
    private javax.swing.JButton del_butoon;
    private javax.swing.JTextField del_title;
    private javax.swing.JTextField dm;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextField hf;
    private javax.swing.JTextField info;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lf;
    private javax.swing.JPanel panel_central;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField rm;
    private javax.swing.JTextField search;
    private javax.swing.JButton search_butoon;
    private javax.swing.JTextArea sinopse;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
