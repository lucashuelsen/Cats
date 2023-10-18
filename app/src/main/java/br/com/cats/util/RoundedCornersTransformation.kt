package br.com.cats.util
import android.graphics.*
import com.squareup.picasso.Transformation

class RoundedCornersTransformation(
    private val radius: Float = 10f,
    private val margin: Float = 0f
) : Transformation {

    override fun transform(source: Bitmap): Bitmap {
        val paint = Paint().apply {
            isAntiAlias = true
            shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        }

        val output = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val rectF = RectF(margin, margin, source.width - margin, source.height - margin)
        canvas.drawRoundRect(rectF, radius, radius, paint)

        if (source != output) {
            source.recycle()
        }

        return output
    }

    override fun key(): String {
        return "rounded_corners"
    }
}
