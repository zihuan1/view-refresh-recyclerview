# 一行代码实现RecyclerView
## 简单使用
* 基本使用

https://github.com/zihuan1/view-grace-recyclerview

* 监听

由 https://github.com/zihuan1/view-recycler-adapter 实现
```
在指定的类中实现ViewOnItemClick接口

class MainActivity : AppCompatActivity() ,ViewOnItemClick{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
	//1实现适配器方法1
        rv_view.buildVerticalLayout<ReAdapter>(this)
	
	
	//实现适配器方法2
	val reAdapter = ReAdapter(this)
        rv_view2.buildVerticalLayout(reAdapter)
	如果一个页面中包含多个recycleview，要匿名内部类的方式实现监听
        reAdapter.setOnItemClick { view, position ->

        }
	//子view监听
        reAdapter.setOnChildClick(object :ViewOnItemChildClick{
            override fun setOnChildClick(view: View?, position: Int) {

            }

            override fun setOnChildLongClick(view: View?, position: Int) {
            }

        },R.id.tvTest)
	}
	
   //点击
    override fun setOnItemClickListener(view: View?, position: Int) {
        Log.e("点击", "$position")
    }

    //长按
    override fun setOnItemLongClickListener(view: View?, position: Int) {
        Log.e("点击", "$position")
    }
}

```


* 依赖地址

implementation 'com.github.zihuan1:view-complete-recyclerview:last.integration'

 
