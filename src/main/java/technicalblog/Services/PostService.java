package technicalblog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.model.PostCreated;
import technicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository pr;

    public List<Post> getAllPosts() {
//        ArrayList<Post> posts = new ArrayList<Post>();

//        Post post1 = new Post();
//        post1.setTitle("Post 1");
//        post1.setBody("Post Body 1");
//        post1.setDate(new Date());
//
//        Post post2 = new Post();
//        post2.setTitle("Post 2");
//        post2.setBody("Post Body 2");
//        post2.setDate(new Date());
//
//        Post post3 = new Post();
//        post3.setTitle("Post 3");
//        post3.setBody("Post Body 3");
//        post3.setDate(new Date());
//
//        posts.add(post1);
//        posts.add(post2);
//        posts.add(post3);


//        try {
//            Class.forName("org.postgresql.Driver"); //loads the driver
//            Connection connection = DriverManager.getConnection("jdbc:postgresql:" +
//                    "//localhost:5432/technicalblog", "postgres", "German*123");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
//            while (rs.next()) {
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                post.setDate(new Date());
//                posts.add(post);
//            }
//
//
//        } catch (ClassNotFoundException | SQLException error) {
//            error.printStackTrace();
//        }

//        EntityManager em = emf.createEntityManager();
//        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
//        List<Post> list = query.getResultList();
//
//
//        return list;

        return pr.getAllPosts();
    }

    public Post getOnePost() {
//        ArrayList<Post> posts = new ArrayList<Post>();

//        Post post1 = new Post();
//        post1.setTitle("Your First Post");
//        post1.setBody("Hi, You have written this in your first post. Congrats!");
//        post1.setDate(new Date());
//        posts.add(post1);

//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql:" +
//                    "//localhost:5432/technicalblog");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts WHERE id = 1");
//            while (rs.next()) {
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                post.setDate(new Date());
//                posts.add(post);
//            }
//
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }


//        @PersistenceUnit(unitName = "techblog")
//        EntityManagerFactory emf;
//
//        EntityManager em = emf.createEntityManager();
//        Post post = em.find(Post.class, 3);
//        return post;
        return pr.getLatestPost();
    }

    public ArrayList<Post> createCustomPost(Post post) {
        ArrayList<Post> posts = new ArrayList<Post>();

        Post post1 = new Post();
        post1.setTitle(post.getTitle());
        post1.setBody(post.getBody());
        post1.setDate(new Date());
//        pr.createPost(post);
        posts.add(post1);
        return posts;
    }

    public void createPost(Post newPost) {
        pr.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }

    public Post getPost(Integer postId) {
        return pr.getPost(postId);
    }

    public void editPost(Post editedPost) {
         pr.editPost(editedPost);
    }

    public void deletePost(Integer postId) {
        pr.deletePost(postId);
    }
}
