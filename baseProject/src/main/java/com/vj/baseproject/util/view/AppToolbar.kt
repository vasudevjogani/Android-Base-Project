/*

Copy right here
 */

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.vj.baseproject.util.extension.setVisible
import com.vj.baseproject.R
import com.vj.baseproject.databinding.LayoutToolbarBinding

class AppToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {
    lateinit var binding: LayoutToolbarBinding

    init {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        binding = LayoutToolbarBinding.inflate(LayoutInflater.from(context), this, true)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AppToolbar)
        val title = typedArray.getString(R.styleable.AppToolbar_title)
        val showBack = typedArray.getBoolean(R.styleable.AppToolbar_showBack, true)
        binding.ivBack.setVisible(showBack)
        binding.tvTitle.text = title
        typedArray.recycle()
    }
}
