




// Nếu đề là depth thì coppy này thêm số 2 dzô nha

//
//  int count =0;
// void depth2(boolean [] visited,int k, RandomAccessFile f) throws Exception {
//     if(count >=1 && count <5)     fvisit(k,f);
//     count++;visited[k]=true;
//    for(int i=0;i<n;i++) {
//      if(!visited[i] && a[k][i]>0) depth2(visited,i,f);
//     }
//   }
// 
//  void depth2(int k, RandomAccessFile f) throws Exception {
//    boolean [] visited = new boolean[20];
//    int i;
//    for(i=0;i<n;i++) visited[i]=false;
//    depth2(visited,k,f);
//    for(i=0;i<n;i++) 
//       if(!visited[i]) depth2(visited,i,f);
//   }
//


// Nếu đề là Breadth 

// void breadth2(int k, RandomAccessFile f) throws Exception {
//        Queue q = new Queue();
//        int i,h;
//        boolean [] enqueued = new boolean[n];
//        for(i = 0; i < n; i++) 
//            enqueued[i] = false;
//        
//        q.enqueue(k);
//        enqueued[k] = true;
//        int count =0;
//        while(!q.isEmpty()){
//            h = q.dequeue();
//            if(h!=k &&count >=1 && count <=5)  fvisit(h, f); 
//                count++;
//            for(i = 0; i < n; i++)
//                if(!enqueued[i] && a[h][i] > 0) {
//                    q.enqueue(i);
//                    enqueued[i] = true;
//                }
//        }
//        
//        System.out.println();
//    }






// distra

// void findPathDijkstra(int start,int des, RandomAccessFile f) throws Exception{
//        //initiation
//        int check[]=new int[n];  //kiem tra dinh da xet
//        int d[]=new int[n];      // khoang cach ngan nhat hien tai
//        int pre[]=new int[n];   // luu vet
//        ArrayList<Integer> s  = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            if(i!=start){
//                check[i] = 0;    //dinh i chua xet
//                pre[i] = start;      //truoc i la s 
//                if (a[start][i] != 99)  d[i] = a[start][i];                    
//                else d[i]=Integer.MAX_VALUE;
//            }
//        }
//        d[start]=0;
//        pre[start]=-1;
//        check[start]=1;
//        //routine for setting label
//        int count=1;
//        do {          
//            //find vertex u having d[u] min for setting label
//            int min=Integer.MAX_VALUE;
//            int u=0;
//            for (int i = 0; i < n; i++) {
//                if(min>d[i] && check[i]==0){
//                    u=i;
//                    min=d[i];
//                }
//            }
//            check[u]=1;
//            s.add(u); // cap nhat dinh S 
//            //update the paths of the vertices adjacent to vertex u these are not labeling
//            for (int i = 0; i < n; i++) {
//                if (u!=i && check[i] == 0) {
//                    if (d[i]>d[u]+a[u][i]) {
//                        d[i]=d[u]+a[u][i];
//                        pre[i]=u;
//                    }
//                }
//            }
//            count++;
//        } while (count<=n);
//        //export the shortest path from vertex start
//      ArrayList<Integer> path=new ArrayList<>();   // duyet theo cai pre suy ra cai duong di 
//      path.add(des);
//      int j = des;
//      do {
//          if (pre[j] != -1) {
//              j = pre[j];
//              path.add(j);
//          }
//      } while (pre[j] != -1);
//      //print the shortest path
//      for (int i = path.size()-1; i >=0; i--) {
//          fvisit(path.get(i),f);
//      }
//      f.writeBytes("\n");
//    }












// Distra nhưng mà có thêm mảng S nữa
//
//  void findPathDijkstra2(int start,int des, RandomAccessFile f) throws Exception{
//        //initiation
//        int check[]=new int[n];  //kiem tra dinh da xet
//        int d[]=new int[n];      // khoang cach ngan nhat hien tai
//        int pre[]=new int[n];   // luu vet
//        ArrayList<Integer> s  = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            if(i!=start){
//                check[i] = 0;    //dinh i chua xet
//                pre[i] = start;      //truoc i la s 
//                if (a[start][i] != 99)  d[i] = a[start][i];                    
//                else d[i]=Integer.MAX_VALUE;
//            }
//        }
//        d[start]=0;
//        pre[start]=-1;
//        check[start]=1;
//        //routine for setting label
//        int count=1;
//        do {          
//            //find vertex u having d[u] min for setting label
//            int min=Integer.MAX_VALUE;
//            int u=0;
//            for (int i = 0; i < n; i++) {
//                if(min>d[i] && check[i]==0){
//                    u=i;
//                    min=d[i];
//                }
//            }
//            check[u]=1;
//            s.add(u); // cap nhat dinh S 
//            //update the paths of the vertices adjacent to vertex u these are not labeling
//            for (int i = 0; i < n; i++) {
//                if (u!=i && check[i] == 0) {
//                    if (d[i]>d[u]+a[u][i]) {
//                        d[i]=d[u]+a[u][i];
//                        pre[i]=u;
//                    }
//                }
//            }
//            count++;
//        } while (count<=n);
//        //export the shortest path from vertex start
//      //print the shortest path
//      for (int i = s.size() -4; i <s.size()-1;i++) {
//          fvisit(s.get(i),f);
//      }
//      f.writeBytes("\n");
//    }
//
//
