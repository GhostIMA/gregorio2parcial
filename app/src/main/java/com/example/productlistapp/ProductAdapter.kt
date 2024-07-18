import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(this, productList) { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    val productList = listOf(
        Product("Producto 1", "Descripcion de Producto 1", 40.99),
        Product("Producto 2", "Descripcion of Producto 2", 50.99),
        Product("Producto 3", "Descripcion de Producto 3", 60.99)
    )
}
